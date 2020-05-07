package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cts.model.User;
import com.cts.repository.UserRepository;

public interface IUserService  {
	
	
	public List<User> getAllUser();
}
