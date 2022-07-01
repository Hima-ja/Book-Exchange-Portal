package com.books.exchange.controllers;



import javax.validation.Valid;

import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.books.exchange.entities.Books;
import com.books.exchange.entities.User;
import com.books.exchange.exceptions.PasswordMismatchException;
import com.books.exchange.exceptions.UserAlreadyExistsException;
import com.books.exchange.payloads.BooksDto;
import com.books.exchange.payloads.UserDto;
import com.books.exchange.repositories.UserRepo;
import com.books.exchange.services.UserService;
import com.books.exchange.services.impl.BookServiceImpl;
import com.books.exchange.services.impl.UserServiceImpl;

@Controller
public class MainController {
	
	
	
	@Autowired
	private UserServiceImpl userService;
	private BookServiceImpl bookService;
	private UserRepo userRepo;
	
	@GetMapping("/")
	public String home() {
		return "opening";
	}
	@GetMapping("/SignUp")
	public String register(Model model){
		User user = new User();
        model.addAttribute("user",user);
		return "register1";
	}
	@GetMapping("/Login")
	public String login() {
		return "login";
	}
	@PostMapping("/process_register")
	public String submitForm(@Valid @ModelAttribute("user") User user,BindingResult bindingResult){
		UserDto userdto = this.userService.userToDto(user);
		try {
			if(user.getPassword()!=user.getConfirm_password()) {
				throw new PasswordMismatchException();
			}
			if(userService.checkIfUserExists(user.getEmail())){
	            throw new UserAlreadyExistsException();
	        }
			if(bindingResult.hasErrors()) {
				return "register1";
			}
			this.userService.createUser(userdto);

		}
		catch(UserAlreadyExistsException e) {
			bindingResult.rejectValue("email","user.email","An account already exists for this email");
			return "register1";
		}
		catch(PasswordMismatchException e) {
			bindingResult.rejectValue("password","user.password","Passwords don't match");
			bindingResult.rejectValue("confirm_password","user.confirm_password","Passwords don't match");
			return "register1";
		}
		return "dashboard";
		}
	
	@GetMapping("/process_register")
	public String getdata(Model model) {
		return "dashboard";
	}

	@GetMapping("/Dashboard")
		public String dash() {
			return "dashboard";
		}
	@GetMapping("/Profile")
	public String userPro(@ModelAttribute("user") User user) {
		return "profile";
	}
	
	@PostMapping("/process_publish")
	public String mybooks(@ModelAttribute Books books) {
		BooksDto bookdto = this.bookService.bookToDto(books);
		 bookService.publishBook(bookdto);
		 return "MyBooks";
	}
	@GetMapping("/process_publish")
	public String publishing() {
		return "MyBooks";
	}
	@GetMapping("/publish")
	public String getbooks() {
		return "publishing";
	}
	@GetMapping("/MyBooks")
	public String books() {
		return "MyBooks";
	}
	@GetMapping("/Admins")
	public String admins() {
		return "Admins";
	}
	
}



