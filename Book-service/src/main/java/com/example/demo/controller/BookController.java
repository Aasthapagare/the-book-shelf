package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.BookRepository;
import com.example.demo.model.Book;

@RequestMapping("/books")
@RestController
public class BookController {

	private BookRepository bookRepository;

	public BookController(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}
	@PostMapping
	public Book addBook(@RequestBody Book book) {
		return bookRepository.save(book);
	}
	@GetMapping
	public List<Book> findAllBooks(){
		return bookRepository.findAll();	
	}
	@GetMapping("/{id}")
	public Book findById(@PathVariable("id") int id) {
		return bookRepository.findById(id).orElse(null);
	}
}
