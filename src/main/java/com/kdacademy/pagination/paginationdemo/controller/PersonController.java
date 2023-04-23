package com.kdacademy.pagination.paginationdemo.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kdacademy.pagination.paginationdemo.model.Person;
import com.kdacademy.pagination.paginationdemo.repository.PersonRepository;

@RestController
@RequestMapping("/api/people")
public class PersonController {
    private final PersonRepository personRepository ;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public Page<Person> findAll(@RequestParam int page, @RequestParam int size){
        PageRequest pr = PageRequest.of(page, size) ;
        return personRepository.findAll(pr) ;
    }
}
