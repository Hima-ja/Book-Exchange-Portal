package com.books.exchange.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BooksDto {
	
	private int book_id;
	private String Author;
	private String bookTitle;
	private int Edition;
	private int Year;
	private String Description;
	
	

}
