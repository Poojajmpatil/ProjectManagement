package com.cts.repository;

import org.springframework.data.repository.CrudRepository;

import com.cts.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
