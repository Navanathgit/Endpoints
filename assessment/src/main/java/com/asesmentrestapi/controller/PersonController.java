package com.asesmentrestapi.controller;
import com.asesmentrestapi.exception.ResourceNotFoundException;
import com.asesmentrestapi.payload.PersonDTO;
import com.asesmentrestapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService service;

    // Endpoint to get an array of randomly generated persons
    // http://localhost:8080/persons
    @GetMapping
    public ResponseEntity<List<PersonDTO>> getRandomPersons() {
        List<PersonDTO> randomPersons = service.generateRandomPersons(); // You can adjust the number of random persons to be generated
        return new ResponseEntity<>(randomPersons, HttpStatus.OK);
    }

    // Endpoint to get a randomly generated person by ID
    // http://localhost:8080/persons/{random_id}
    @GetMapping("/{random_id}")
    public ResponseEntity<PersonDTO> getRandomPersonById(@PathVariable("random_id") int randomId) {
        PersonDTO randomPerson = service.generateRandomPerson(randomId);
        if (randomPerson != null) {
            return new ResponseEntity<>(randomPerson, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Person not found with ID: " + randomId);
        }
    }
}
