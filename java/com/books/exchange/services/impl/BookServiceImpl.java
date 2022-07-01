package com.books.exchange.services.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.exchange.entities.Books;
import com.books.exchange.exceptions.ResourceNotFoundException;
import com.books.exchange.payloads.BooksDto;
import com.books.exchange.repositories.BooksRepo;
import com.books.exchange.services.BooksService;

@Service
public class BookServiceImpl implements BooksService {
	@Autowired
	private BooksRepo booksRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public BooksDto publishBook(BooksDto booksDto) {
		Books book = this.dtoToBook(booksDto);
		Books savedBook = this.booksRepo.save(book);
		return this.bookToDto(savedBook);
	}
	@Override 
	public void publishBooks(BooksDto booksDto) {
		Books book = this.dtoToBook(booksDto);
		this.booksRepo.save(book);
	}

	@Override
	public BooksDto updateBookInfo(BooksDto booksDto,int book_id) {
		Books book = this.booksRepo.findById(book_id).orElseThrow (()->new ResourceNotFoundException("Books","book_id",book_id));
		book.setAuthor(booksDto.getAuthor());
		book.setBookTitle(booksDto.getBookTitle());
		book.setEdition(booksDto.getEdition());
		book.setYear(booksDto.getYear());
		book.setDescription(booksDto.getDescription());
		Books updatedBook = this.booksRepo.save(book);
		BooksDto bookDto1 = this.bookToDto(updatedBook);
		return bookDto1;
	}

	@Override
	public void deletePublishedItem(int book_id) {
		Books book = this.booksRepo.findById(book_id).orElseThrow(()->new ResourceNotFoundException("Books","book_id",book_id));
		this.booksRepo.delete(book);

	}

	@Override
	public BooksDto getBookById(int book_id) {
Books book = this.booksRepo.findById(book_id).orElseThrow(()->new ResourceNotFoundException("Books","book_id",book_id));
		
		return this.bookToDto(book);
	}

	@Override
	public List<BooksDto> getAllBooks() {
		List <Books> books = this.booksRepo.findAll();
        List <BooksDto> bookDtos = books.stream().map(book->this.bookToDto(book)).collect(Collectors.toList());
        
	
		return bookDtos;
	}
	public Books dtoToBook(BooksDto booksDto) {
		Books book = this.modelMapper.map(booksDto,Books.class);
		
		return book;
		
		
		
	}
	public BooksDto bookToDto(Books book) {
		BooksDto bookDto = this.modelMapper.map(book,BooksDto.class);
		return bookDto;
		
	}


}
