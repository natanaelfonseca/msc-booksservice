package br.com.treinamento.bookws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinamento.bookws.client.stockws.Stock;
import br.com.treinamento.bookws.client.stockws.StockFeignClient;
import br.com.treinamento.bookws.model.Book;
import br.com.treinamento.bookws.repository.BooksRepository;

@RestController
@RequestMapping("/v1/books")
public class BooksController {
	
	//Feign Client
    @Autowired
    StockFeignClient stockService;

	@Autowired
	private BooksRepository booksRepository;

	@GetMapping
	public List<Book> list() {
		return booksRepository.findAll();
	}

	@GetMapping("/{id}")
	public Book get(@PathVariable("id") long id) {
		return booksRepository.getOne(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Book book) {
		booksRepository.save(book);
	}

	@GetMapping("/allbalances")
	public List<Stock> get() {
		return stockService.getAllBalance();
	}
	
}