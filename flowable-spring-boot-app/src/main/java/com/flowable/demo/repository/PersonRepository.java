package com.flowable.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flowable.demo.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
	
	Person findByUserName(String unsename);
}
