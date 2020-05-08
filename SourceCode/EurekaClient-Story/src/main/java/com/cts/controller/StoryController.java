package com.cts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.feign.StoryFeignClient;
import com.cts.model.Story;
import com.cts.model.User;
import com.cts.service.DemoFeignService;
import com.cts.service.IStoryService;

@RestController
public class StoryController {
	
	@Autowired
	IStoryService iStoryService;
	
//..........................Feign...................................
	
	@Autowired
	StoryFeignClient storyFeignClient;
	
	@Autowired
	DemoFeignService demoFeignService;
	
	@RequestMapping("/users")
	 public List<User> getAllUser()
	{
		return storyFeignClient.getAllUser();
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable Long id) {
		User user1 = storyFeignClient.getUserById(id) ;
			//Long r= user1.getRole_id();	
			return user1;
		
	}
	
//.......................................................................
	
	@PostMapping("/insertstory/{id}")
	public String addStory(@PathVariable Long id ,@RequestBody Story story) {
		String result = iStoryService.addStory(id,story);
		return result;	
		
	}
	
	@GetMapping("/stories")
	public List<Story> getAllStory(){
		return iStoryService.getAllStory();
	}
	
	@PostMapping("/story")
	public void saveStory(@RequestBody Story story) {
		iStoryService.saveStory(story);
	}
	

	@PutMapping(value = "/story/{id}")
	public HttpStatus updateStory(@PathVariable Long id,@RequestBody Story story) {
		
		return iStoryService.updateStory(id,story)  ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}
	
	
	@RequestMapping(value = "/story/{id}", method = RequestMethod.DELETE)
	public HttpStatus deleteStory(@PathVariable Long id) {
		iStoryService.deleteStory(id);
		return HttpStatus.NO_CONTENT;
	}

	@GetMapping("/story/{id}")
	public Optional<Story> getById(@PathVariable Long id) {
	    return iStoryService.getById(id) ;
	}
	
	
	
}