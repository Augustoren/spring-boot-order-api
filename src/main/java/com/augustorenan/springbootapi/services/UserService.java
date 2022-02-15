package com.augustorenan.springbootapi.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.augustorenan.springbootapi.entities.User;
import com.augustorenan.springbootapi.repositories.UserRepository;
import com.augustorenan.springbootapi.services.exceptions.DatabaseException;
import com.augustorenan.springbootapi.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User findUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public void deleteUser(Long id) {
		try {
			userRepository.deleteById(id);			
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User updateUser(Long id, User user) {
		User entity;
		try{
			entity = userRepository.getById(id);
			updateUserData(entity, user);			
			return userRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public void updateUserData(User entity, User user) {
		entity.setFirstName(user.getFirstName());
		entity.setLastName(user.getLastName());
		entity.setEmail(user.getEmail());
	}
}
