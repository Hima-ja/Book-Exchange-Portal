package com.books.exchange.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="books")
@NoArgsConstructor
@Getter
@Setter
public class Requests {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private int reqId;
	private int Userid_1;
	private int Userid_2;
	private String bookTitle;
	private LocalDateTime ExpReturnDate;
	private LocalDateTime IssueDate;


}
