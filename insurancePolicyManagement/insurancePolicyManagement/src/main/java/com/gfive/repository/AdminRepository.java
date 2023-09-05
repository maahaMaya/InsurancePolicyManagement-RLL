package com.gfive.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfive.domain.Admin;

@Repository(value = "adminRepository")
@Scope(value = "singleton")
public interface AdminRepository extends JpaRepository<Admin, Integer>{

}
