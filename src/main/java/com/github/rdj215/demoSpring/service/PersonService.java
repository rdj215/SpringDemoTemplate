package com.github.rdj215.demoSpring.service;

import com.github.rdj215.demoSpring.model.Person;
import com.github.rdj215.demoSpring.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository=personRepository;

    }

    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }
}
