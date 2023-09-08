package com.gfive.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfive.domain.ContactUs;

@Repository(value = "contactUsRepository")
@Scope(value = "singleton")
public interface ContactUsRepository extends JpaRepository<ContactUs, Integer>{

}