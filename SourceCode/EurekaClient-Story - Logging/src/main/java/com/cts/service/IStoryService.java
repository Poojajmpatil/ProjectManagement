package com.cts.service;

import java.util.List;
import java.util.Optional;

import com.cts.model.Story;

public interface IStoryService {
	
	public List<Story> getAllStory();
	public void saveStory(Story story);
	public boolean updateStory(Long id,Story story);
	public void deleteStory(Long id);
	public Optional<Story> getById(Long id);

}
