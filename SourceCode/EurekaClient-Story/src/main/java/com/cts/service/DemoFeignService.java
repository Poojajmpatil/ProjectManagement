package com.cts.service;

import org.springframework.stereotype.Service;


@Service
public class DemoFeignService {

	public String getUserRole(Long userId)
	{
		String userRole=null;
		
		if(userId ==100 )
			userRole="Skrum Master";
		else
			userRole="Project Member";
			
		
		return userRole;
		
	}

	
	
}
