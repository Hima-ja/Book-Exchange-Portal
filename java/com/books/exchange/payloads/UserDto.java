package com.books.exchange.payloads;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;


import lombok.NoArgsConstructor;
//Used for data transfer

@NoArgsConstructor
@Setter
@Getter
public class UserDto {
	private int id;
	

	private String Name;
	
	
	@Email(message ="Email address is not valid !!")
	private String email;
	
	
	private String password;
	
	@NotNull
	private String contact_no;
	private String address;
	


	
}
