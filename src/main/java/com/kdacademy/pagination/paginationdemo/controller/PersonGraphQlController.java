package com.kdacademy.pagination.paginationdemo.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.kdacademy.pagination.paginationdemo.model.Person;
import com.kdacademy.pagination.paginationdemo.repository.PersonRepository;

@Controller
public class PersonGraphQlController {
    private final PersonRepository personRepository ;

    public PersonGraphQlController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    
    @QueryMapping
    public Iterable<Person> allPeople(){
       return personRepository.findAll() ; 
    }

    @QueryMapping
    public Page<Person> allPeoplePaged(@Argument int page,@Argument int size){
        PageRequest pr = PageRequest.of(page, size) ;
        return personRepository.findAll(pr) ;
    }
}
