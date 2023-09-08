package com.gfive.repository;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gfive.domain.User;


@Repository(value = "userRepository")
@Scope(value = "singleton")
public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query("SELECT u FROM User u WHERE ((u.user_name LIKE %?1%) OR (u.user_email LIKE %?1%))")
	public List<User> searchUserByKeyWord(String serachUserKeyword);
	
	@Query("SELECT u FROM User u WHERE ((u.user_email LIKE %?1%))")
	public User searchUserByEmail(String user_email);
}
