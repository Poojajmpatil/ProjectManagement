package com.cts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.exception.AccessControlException;
import com.cts.feign.StoryFeignClient;
import com.cts.model.User;

@Component
public class GetAccess {
	
	@Autowired
	StoryFeignClient storyFeignClient;
	
	public Boolean getRoleAccess(Long id)
	{
		User user1 = storyFeignClient.getUserById(id) ;
		Long role= user1.getRole_id();	
		if(role == 0)
			return true;
		else
		{	 throw new AccessControlException();
			
		}
		
	}

}
