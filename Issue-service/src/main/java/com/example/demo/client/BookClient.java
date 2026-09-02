package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.BookDto;

@FeignClient(name="Book-service")
public interface BookClient {
	@GetMapping("/books/{id}")
	public BookDto findAllBooksDto(@PathVariable("id") int id);

}
