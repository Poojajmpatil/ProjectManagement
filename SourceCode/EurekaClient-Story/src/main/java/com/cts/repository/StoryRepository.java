package com.cts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cts.model.Story;

public interface StoryRepository extends CrudRepository<Story,Long>
{
	@Query("select s from Story s where s.user_id=:userid")
	public List<Story> getstorylist(@Param(value = "userid") Long userid);
	

}
