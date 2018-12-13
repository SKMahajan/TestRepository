package com.minutes.cache;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppRunner{

	private final BookRepository bookRepo;

	@Autowired
	public AppRunner(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}

	@GetMapping("/books")
	public void fetchBooks() {
		// TODO Auto-generated method stub
		System.out.println("isbn-1234 -->" + bookRepo.getByIsbn("isbn-1234") + new Date());
		System.out.println("isbn-5678 -->" + bookRepo.getByIsbn("isbn-5678") + new Date());
		System.out.println("isbn-1234 -->" + bookRepo.getByIsbn("isbn-1234") + new Date());
		System.out.println("isbn-1234 -->" + bookRepo.getByIsbn("isbn-1234") + new Date());
		System.out.println("isbn-5678 -->" + bookRepo.getByIsbn("isbn-5678") + new Date());
		System.out.println("isbn-5678 -->" + bookRepo.getByIsbn("isbn-5678") + new Date());
		System.out.println("isbn-1234 -->" + bookRepo.getByIsbn("isbn-1234") + new Date());
		System.out.println("isbn-1234 -->" + bookRepo.getByIsbn("isbn-1234") + new Date());
		System.out.println("isbn-5678 -->" + bookRepo.getByIsbn("isbn-5678") + new Date());
		System.out.println("isbn-5678 -->" + bookRepo.getByIsbn("isbn-5678") + new Date());
	}

}
