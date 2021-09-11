package com.gestion.cv.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gestion.cv.entites.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	User findByLogin(String login);

}
