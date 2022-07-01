package com.books.exchange.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.books.exchange.entities.Books;
import com.books.exchange.entities.Requests;

public interface ReqRepo extends JpaRepository<Requests,Integer>{
	
}