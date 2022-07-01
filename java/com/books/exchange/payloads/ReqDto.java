package com.books.exchange.payloads;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class ReqDto {
	
	private int reqId;
	private int Userid_1;
	private int Userid_2;
	private String bookTitle;
	private LocalDateTime ExpReturnDate;
	private LocalDateTime IssueDate;


}

