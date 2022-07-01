package com.books.exchange.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.books.exchange.entities.Books;

public interface BooksRepo extends JpaRepository<Books,Integer>{
	
}