package com.books.exchange.repositories;



import org.springframework.data.jpa.repository.JpaRepository;


import com.books.exchange.entities.User;

public interface UserRepo extends JpaRepository<User,Integer>{

	User findByemail(String email);



	

	
	
}
