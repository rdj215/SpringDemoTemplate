package com.github.rdj215.demoSpring.controller;

import com.github.rdj215.demoSpring.model.Person;
import com.github.rdj215.demoSpring.service.PersonService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PersonController {
    private PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service=service;
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        Iterable<Person> allPeople = service.findAll();
        ResponseEntity<?> response = new ResponseEntity<>(allPeople, HttpStatus.OK);
        return response;
    }

}
