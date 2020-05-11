package com.cts.service;

import java.util.List;
import java.util.Optional;

import com.cts.model.Story;

public interface IStoryService {
	
	public List<Story> getAllStory();
	//public void saveStory(Story story);
	public String updateStory(Long id,Story story,Long updateid);
	public String deleteStory(Long id,Long deleteid);
	public Optional<Story> getStoryById(Long id);
	public String addStory(Long id, Story story);
	

}
