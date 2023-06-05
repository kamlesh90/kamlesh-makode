package com.flowable.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flowable.demo.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
	
	Person findByUserName(String unsename);
}
