package com.cts.feign;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.cts.model.User;

@FeignClient(name = "userclient")
public interface StoryFeignClient {
	
	@GetMapping("/users")
	List<User> getAllUser();
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable Long id);
	
	
	

}
