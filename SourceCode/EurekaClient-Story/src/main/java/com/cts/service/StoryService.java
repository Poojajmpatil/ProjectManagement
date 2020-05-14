package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.GetAccess;
import com.cts.exception.StoryNotFoundException;
import com.cts.feign.StoryFeignClient;
import com.cts.model.Story;
import com.cts.repository.StoryRepository;


	@Service
	@Transactional
	public class StoryService implements IStoryService {
	    
		@Autowired
		StoryRepository storyRepository;
		
		@Autowired
		GetAccess getAccess;
		
		@Autowired
		StoryFeignClient storyFeignClient;
		
		public List<Story> getAllStory(){
			return (List<Story>) storyRepository.findAll();
		}
		
		public void saveStory(Story story) {
			storyRepository.save(story);
		}	
		
//...........................................................................
	
		public String addStory(Long id,Story story) {	
			if(getAccess.getRoleAccess(id))
			{
				storyRepository.save(story);
				return "Operation has been completed successfully ";
			}	
			return null;
		}
		
//........................................................................

		public String updateStory(Long id,Story story,Long updateid) throws StoryNotFoundException {
			
		if(getAccess.getRoleAccess(id))
		{
			storyRepository.findById(updateid)
			.orElseThrow(() -> new StoryNotFoundException());
			storyRepository.save(story);
			return "Update operation has been completed successfully ";
		}	
		return null;
		
		}

		
		
		public String deleteStory(Long id,Long deleteid) throws StoryNotFoundException  {
			if(getAccess.getRoleAccess(id))
			{	
				storyRepository.findById(deleteid)
						.orElseThrow(() -> new StoryNotFoundException());
				storyRepository.deleteById(deleteid);
				return "Delete operation has been completed successfully ";
			}
			return null;
		}
		
		public Optional<Story> getStoryById(Long id) {
		storyRepository.findById(id) 
					.orElseThrow(() -> new StoryNotFoundException());
			return storyRepository.findById(id);
					
		}

		

		
		
	}