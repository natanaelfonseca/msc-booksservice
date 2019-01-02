package br.com.treinamento.bookws.client.stockws;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("msc-stockws")
public interface StockFeignClient {

	@RequestMapping(method = RequestMethod.GET,
					value = "/api/v1/stocks/",
					consumes = "application/json")
	List<Stock> getAllBalance();

}