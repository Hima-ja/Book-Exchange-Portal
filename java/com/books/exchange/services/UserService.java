package com.books.exchange.services;
import java.util.List;

import com.books.exchange.entities.User;
import com.books.exchange.payloads.UserDto;
//We can take it from the user entity itself but in the payloads,we can directly expose data to the api.Since the entity is a part of the database construction
public interface UserService {
	void createUser(UserDto userDto) ;
	UserDto userProfile(UserDto userDto);
	UserDto updateUser(UserDto userDto,int userId);//Profile 
	UserDto getUserById(int userId);//Login and redirecting to the dashboard
	List<UserDto> getAllUsers();
	void deleteUser(int userId);
	boolean checkIfUserExists(String email);
	
}
