package com.cts.controller;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.cts.model.User;

import com.cts.service.UserService;

@RestController
@Validated
public class UserController {
 
	@Autowired
	UserService userService;

	@GetMapping("/users")
	public List<User> getAllUser(){
		return userService.getAllUser();
	}
	
	
	@PostMapping("/user")
	public void insertStudent(@Valid @RequestBody User user) {
		userService.saveUser(user);
	}

	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public HttpStatus updateUser(@RequestBody User user) {
		return userService.updateUser(user)  ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}
	
	@GetMapping("/user/{id}")
	public Optional<User> getUserById(@PathVariable Long id) {
	    return userService.getUserById(id) ;
	}
	
	
	
}
