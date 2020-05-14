package com.cts.repository;

import org.springframework.data.repository.CrudRepository;

import com.cts.model.Story;

public interface StoryRepository extends CrudRepository<Story, Long>
{
	

}
