package com.github.rdj215.demoSpring.service;

import com.github.rdj215.demoSpring.model.Person;
import com.github.rdj215.demoSpring.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {
    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;

    }

    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }


    public Person create(Person person) {
        return personRepository.save(person);
    }

//    public Person update(Long id, Person person){
//    return null;
//    }

//    public Boolean delete(Long id) {
//        personRepository.deleteById(id);
//        return true;
//    }

    public Person findById(Long id) {
        return  personRepository.findById(id).get();
    }

    public Person delete(Long id) {
        Person personToBeDeleted = this.findById(id);
        personRepository.delete(personToBeDeleted);
        return personToBeDeleted;
    }

    public Person update(Long id, Person person) {
        Person personToBeUpdated = findById(id);

        String newFirstName = person.getFirstName();
        String newLastName = person.getLastName();

        personToBeUpdated.setFirstName(newFirstName);
        personToBeUpdated.setLastName(newLastName);

        personRepository.save(personToBeUpdated);
        return personToBeUpdated;

    }


}
