package com.railway.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.railway.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

	boolean existsByEmail(String email);
	
	boolean existsByUserName(String userName);
	
	Optional<User> findByUserNameAndPassword(String userName, String password);
}
