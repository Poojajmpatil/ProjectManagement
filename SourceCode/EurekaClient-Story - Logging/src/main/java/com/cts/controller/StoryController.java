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

import com.cts.model.Story;
import com.cts.service.IStoryService;

@RestController
public class StoryController {
	
	@Autowired
	IStoryService iStoryService;
	
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