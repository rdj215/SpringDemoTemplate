package com.github.rdj215.demoSpring.controller;

import com.github.rdj215.demoSpring.model.Person;
import com.github.rdj215.demoSpring.service.PersonService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PersonController {
    private PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service=service;
    }


    @GetMapping("/person/")
    public ResponseEntity<?> findAll() {
        Iterable<Person> allPeople = service.findAll();
        ResponseEntity<?> response = new ResponseEntity<>(allPeople, HttpStatus.OK);
        return response;
    }


    @GetMapping("/person/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
       Person person = service.findById(id);
        ResponseEntity<?> responseEntity = new ResponseEntity<>(person, HttpStatus.OK);
        return responseEntity;

    }

    @PostMapping("/person/")
    public ResponseEntity<?> create(@RequestBody Person person){
        person = service.create(person);
        ResponseEntity<?> response = new ResponseEntity<>(person,HttpStatus.CREATED);
        return response;

        }


     @PutMapping("/person/{id}")
     public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Person person){
       Person responseBody = service .update(id,person);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK );
        return responseEntity;
     }

   @DeleteMapping("/person/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
       Person person = service.delete(id);
          ResponseEntity<?> response = new ResponseEntity<>(person,HttpStatus.OK);
          return response;
        }
}
