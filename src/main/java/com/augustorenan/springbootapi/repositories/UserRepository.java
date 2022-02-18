package com.augustorenan.springbootapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.augustorenan.springbootapi.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
//	@Query(value = "SELECT * FROM tb_users u WHERE u.email = ?1")
	public User findUserByEmail(String email);

}
