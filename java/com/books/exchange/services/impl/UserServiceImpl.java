package com.books.exchange.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.exchange.entities.User;
import com.books.exchange.exceptions.ResourceNotFoundException;
import com.books.exchange.payloads.UserDto;
import com.books.exchange.repositories.UserRepo;
import com.books.exchange.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private  ModelMapper modelMapper;
	@Override
	public void createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		this.userRepo.save(user);
	}
    public UserDto userProfile(UserDto userDto) {
    	User user = this.dtoToUser(userDto);
    	this.userRepo.save(user);
    	UserDto savedUser = this.userToDto(user);
    	
    	return savedUser;
    }
	@Override
	public UserDto updateUser(UserDto userDto, int userId) {
		User user = this.userRepo.findById(userId).orElseThrow (()->new ResourceNotFoundException("User","id",userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAddress(userDto.getAddress());
		user.setContact_no(userDto.getContact_no());	
		User updatedUser = this.userRepo.save(user);
		UserDto userDto1 = this.userToDto(updatedUser);
		return userDto1;
	}
	@Override
	public boolean checkIfUserExists(String email) {
		
		User user = userRepo.findByemail(email);
		if(user!=null) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	@Override
	public UserDto getUserById(int userId) {
        User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
		return this.userToDto(user);
	}
	public List<UserDto> getAllUsers() {
		List <User> users = this.userRepo.findAll();
        List <UserDto> userDtos = users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
        
	
		return userDtos;
	}

	@Override
	public void deleteUser(int userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
		this.userRepo.delete(user);

	}
	
	private User dtoToUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto,User.class);
		//user.setId(userDto.getId());
		//user.setFirstName(userDto.getFirstName());
		//user.setLastName(userDto.getLastName());
		//user.setEmail_id(userDto.getEmail_id());
		//user.setPassword(userDto.getPassword());
		//user.setWalletBalance(userDto.getWalletBalance());
		
		return user;
		
		
		
	}
	public  UserDto userToDto(User user) {
		UserDto userDto = this.modelMapper.map(user,UserDto.class);
		//userDto.setId(user.getId());
		//userDto.setFirstName(user.getFirstName());
		//userDto.setLastName(user.getLastName());
		//userDto.setEmail_id(user.getEmail_id());
		//userDto.setPassword(user.getPassword());
		//userDto.setWalletBalance(user.getWalletBalance());
		
		return userDto;
		
	}

}
