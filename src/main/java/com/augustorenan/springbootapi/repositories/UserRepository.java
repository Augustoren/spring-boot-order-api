package com.augustorenan.springbootapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.augustorenan.springbootapi.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("SELECT * FROM tb_user WHERE email = ?1")
	public User findUserByEmail(String email);

}
