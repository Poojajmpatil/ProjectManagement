package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.exception.StoryNotFoundException;
import com.cts.model.Story;
import com.cts.repository.StoryRepository;


	@Service
	@Transactional
	public class StoryService implements IStoryService {
	    
		@Autowired
		StoryRepository storyRepository;
		
		public List<Story> getAllStory(){
			return (List<Story>) storyRepository.findAll();
		}
		
		public void saveStory(Story story) {
			storyRepository.save(story);
		}
		
		public boolean updateStory(Long id,Story story) throws StoryNotFoundException {
			
		storyRepository.findById(id)
		.orElseThrow(() -> new StoryNotFoundException());
			
			return storyRepository.save(story) != null;
		}

		
		public void deleteStory(Long id) throws StoryNotFoundException {
			Story story = storyRepository.findById(id)
					.orElseThrow(() -> new StoryNotFoundException());
			
			storyRepository.deleteById(id);	
		}
		
		public Optional<Story> getById(Long id) {
			return storyRepository.findById(id);
		}
		
	}