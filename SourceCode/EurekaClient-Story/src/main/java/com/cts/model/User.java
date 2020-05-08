package com.cts.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor

public  class User {
	
    private Long  user_id;
	private String name;
	private String email;
	private String password;
	private String mobile;
	private Long   role_id;
	
	
	
}
