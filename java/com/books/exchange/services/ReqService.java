package com.books.exchange.services;
import com.books.exchange.payloads.ReqDto;

public interface ReqService {
	
	ReqDto RequestBook(ReqDto reqDto);
	ReqDto DeleteRequest(ReqDto reqDto,int bookId);
	ReqDto ReturnBook(ReqDto reqDto);
	ReqDto RequestExtension(ReqDto reqDto);
	

}
