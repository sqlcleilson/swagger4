package com.swagger4.controllers;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;

import com.swagger4.controllers.requestDtos.CreatePersonRequestBody;
import com.swagger4.controllers.responseDtos.PersonResponseBody;
import com.swagger4.controllers.responseDtos.PersonsResponseBody;
import com.swagger4.models.Person;
import com.swagger4.services.PersonService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons")
public class PersonController {
    
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<String> createPerson(@Validated @RequestBody CreatePersonRequestBody createPersonRequestBody) {
        
        Person person = personService.createPerson(
                createPersonRequestBody.name()
        );
        UUID personId = person.getUuid();
        return ResponseEntity
                .created(URI.create("person/" + personId))
                .build();
        
    }

    @GetMapping
    public ResponseEntity<PersonsResponseBody> getAllPersons() {

        List<Person> allPersons = personService.getAllPersons();
        List<PersonResponseBody> personResponseBodyList = allPersons
                .stream()
                .map(person ->
                        new PersonResponseBody(
                                person.getUuid().toString(),
                                person.getName()
                        )
                ).collect(Collectors.toList());
        return ResponseEntity.ok().body(new PersonsResponseBody(personResponseBodyList));
    }

    @DeleteMapping ("delete/{personId}")
    public ResponseEntity<String> deletePersonById(@PathVariable UUID personId) {
        personService.deletePerson(personId);

        return new ResponseEntity<String>("Person: " + personId + " deleted.", HttpStatus.OK);
    }

}