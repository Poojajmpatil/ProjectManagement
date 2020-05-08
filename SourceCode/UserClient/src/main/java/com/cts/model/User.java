package com.cts.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "User")

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor

public  class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
    private Long  user_id;
	@NotEmpty(message = " name must not be empty")
	@Size(min=2,message = " name must not be less than 2 characters")
	private String name;
	@NotEmpty(message = "Email must not be empty")
	@Email(message = "Email must be a valid email address")
	private String email;
	@NotEmpty(message = "   password must not be empty")
	@Size(min=5,message = " password must not be less than 2 characters")
	private String password;
	@NotEmpty(message = "mobile must not be empty") 
	private String mobile;
	private Long   role_id;
	
	
	
}
