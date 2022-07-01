package com.books.exchange.controllers;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import com.books.exchange.entities.Books;
import com.books.exchange.payloads.Apiresponse;
import com.books.exchange.payloads.BooksDto;
import com.books.exchange.services.BooksService;
import com.books.exchange.services.impl.BookServiceImpl;
import com.books.exchange.utils.FileUploadUtil;


@RestController
@RequestMapping("/api/books")
public class BookController {
	  @Autowired
		private BooksService bookService;
	   private BookServiceImpl bookServiceImpl;
	//POST - create user
		@PostMapping("/")
		public ResponseEntity<BooksDto> publishBook(@Valid @RequestBody BooksDto bookDto){
			BooksDto publishBookDto = this.bookService.publishBook(bookDto);
			return new ResponseEntity<>(publishBookDto,HttpStatus.CREATED);
		}
		@PostMapping("/books_publish")
		public RedirectView saveBook(Books book,@RequestParam("image")MultipartFile multipartFile)throws IOException{
			BooksDto bookdto = this.bookServiceImpl.bookToDto(book);
			String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		book.setPhotos(fileName);
		BooksDto booksdto = this.bookService.publishBook(bookdto);
		Books book_1 = bookServiceImpl.dtoToBook(booksdto);
		String uploadDir = "book-photos/" + book_1.getBook_id();
		FileUploadUtil.saveFile(uploadDir,fileName,multipartFile);
		return new RedirectView("/books_publish",true);}
		//PUT - update user
		
		@PutMapping("/{bookId}")
		public ResponseEntity<BooksDto> updateBookInfo(@Valid @RequestBody BooksDto bookDto,@PathVariable("bookId") int bookId)
		{
			BooksDto updatedBook = this.bookService.updateBookInfo(bookDto, bookId);
			return ResponseEntity.ok(updatedBook);
			
			
	 }
		@DeleteMapping("/{bookId}")
		public ResponseEntity<Apiresponse> deletePublishedItem(@PathVariable("bookId") int bookId)
		{
			this.bookService.deletePublishedItem(bookId);
			return new ResponseEntity<Apiresponse>(new Apiresponse("Book deleted Succesfully", true), HttpStatus.OK);
		}
		@GetMapping("/")
	    public ResponseEntity<List<BooksDto>> getAllBooks()
	    {
			return ResponseEntity.ok(this.bookService.getAllBooks());
	    }
		@GetMapping("/{bookId}")
		 public ResponseEntity<BooksDto> getBookById(@PathVariable int bookId)
		    {
				return ResponseEntity.ok(this.bookService.getBookById(bookId));
		    }
		 
}
