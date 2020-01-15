package com.github.rdj215.demoSpring.repository;

import com.github.rdj215.demoSpring.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

}
