package sn.BMF.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sn.BMF.entites.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	User findByLogin(String login);

}
