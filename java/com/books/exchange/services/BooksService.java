package com.books.exchange.services;
import java.util.*;

import org.springframework.stereotype.Service;

import com.books.exchange.payloads.BooksDto;


public interface BooksService {	
	BooksDto publishBook(BooksDto booksDto);
	void publishBooks(BooksDto booksDto);
	BooksDto updateBookInfo(BooksDto booksDto,int book_id);
    void deletePublishedItem(int bookId);
    BooksDto getBookById(int bookId);
    List <BooksDto> getAllBooks();
}
