package br.com.treinamento.bookws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinamento.bookws.model.Book;

public interface BooksRepository extends JpaRepository<Book, Long>{
}
