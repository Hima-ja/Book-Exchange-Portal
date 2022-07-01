package com.books.exchange.entities;




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
public class Books {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int book_id;
	@Column(name="title",length = 100,nullable = false)
	private String  bookTitle;
	@Column(name="author",length=100,nullable = false)
	private String Author;
	@Column(name="edition",length=100)
	private int Edition;
	@Column(name="year",length=100,nullable=false)
	private int Year;
	@Column(name="description",length=100)
	private String Description;
	@Column(nullable=false,length=64)
	private String photos;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User users;

}
