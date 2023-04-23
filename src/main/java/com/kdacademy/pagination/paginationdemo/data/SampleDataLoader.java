package com.kdacademy.pagination.paginationdemo.data;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.kdacademy.pagination.paginationdemo.model.Address;
import com.kdacademy.pagination.paginationdemo.model.Person;
import com.kdacademy.pagination.paginationdemo.repository.PersonRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SampleDataLoader implements CommandLineRunner{

    private final PersonRepository repository ;
    private final Faker faker ;

    public SampleDataLoader(PersonRepository repository, Faker faker) {
        this.repository = repository;
        this.faker = faker;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Loading sample Data...........");
        //create 100 rows of people in the database
        List<Person> people = IntStream.rangeClosed(1, 100).mapToObj(i -> new Person(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.phoneNumber().cellPhone(),
                faker.internet().emailAddress(),
                new Address(
                    faker.address().streetAddress(),
                    faker.address().city(),
                    faker.address().state(),
                    faker.address().zipCode()
                )
            )).toList() ;
        repository.saveAll(people) ;
    }
    
}
