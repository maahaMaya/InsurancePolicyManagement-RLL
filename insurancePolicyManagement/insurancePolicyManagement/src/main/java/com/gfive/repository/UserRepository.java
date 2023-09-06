package com.gfive.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfive.domain.User;


@Repository(value = "userRepository")
@Scope(value = "singleton")
public interface UserRepository extends JpaRepository<User, Integer>{

}
