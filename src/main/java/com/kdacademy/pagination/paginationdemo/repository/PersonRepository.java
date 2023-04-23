package com.kdacademy.pagination.paginationdemo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.kdacademy.pagination.paginationdemo.model.Person;

public interface PersonRepository extends PagingAndSortingRepository<Person, Integer>{
    
}
