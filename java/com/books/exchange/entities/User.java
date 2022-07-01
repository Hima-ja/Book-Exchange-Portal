package com.books.exchange.entities;

import java.util.HashSet;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="users")
@NoArgsConstructor
@Setter
@Getter
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)	
    private int id;
	@Column(name="user_name",nullable=false,length=25)
    @Size(min = 4,message ="Username must be min of 4 characters!!")
	private String Name;
	@javax.validation.constraints.Email(message = "Please enter a valid e-mail address")
	@Column(name="email" ,unique=true, nullable = false , length = 45)
	private String email;
	@Column(unique=true,nullable=false,length=10)
	private String contact_no;
	@Column(unique=true,nullable=false,length=25)
	@Size(min = 8, max = 20,message = "Password must be min of 8 chars and max of 20 chars !!")
	private String password;
	@Column(unique=true,nullable=false,length=25)
	@Size(min = 8, max = 20,message = "Password must be min of 8 chars and max of 20 chars !!")
	private String confirm_password;
	private boolean isAdmin;
	private String address;
	@OneToMany(mappedBy = "users")
	private Set <Books> books = new HashSet<>();
	


}
