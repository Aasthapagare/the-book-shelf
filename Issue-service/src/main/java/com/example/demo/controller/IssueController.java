package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.client.BookClient;
import com.example.demo.client.StudentClient;
import com.example.demo.dao.IssueRepository;
import com.example.demo.dto.BookDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.model.IssueRecord;



@RequestMapping("/issues")
@RestController
public class IssueController {

	private IssueRepository issueRepository;
	private final BookClient bookClient;
	private final StudentClient studentClient;
	
	public IssueController(IssueRepository issueRepository, BookClient bookClient, StudentClient studentClient) {
		super();
		this.issueRepository = issueRepository;
		this.bookClient = bookClient;
		this.studentClient = studentClient;
	}
	@PostMapping
	public String addRecord(@RequestParam("bookId") int bookId,@RequestParam("studentId") int studentId ) {
		 BookDto bookDto = bookClient.findAllBooksDto(bookId);

	        if(bookDto==null)
	        {
	            return "Error: No such book exists";
	        }

	        StudentDto studentDto=studentClient.findByIdDto(studentId);

	        if(studentDto==null)
	        {
	            return "Error: No such student exists";
	        }

	        IssueRecord issueRecord= new IssueRecord();
	        issueRecord.setBookId(bookId);
	        issueRecord.setStudentId(studentId);
	        issueRecord.setIssueDate(LocalDate.now());
	        issueRepository.save(issueRecord);
	        return "record insert";
	}
	
}
