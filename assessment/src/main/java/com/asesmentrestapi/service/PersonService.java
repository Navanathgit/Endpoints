package com.asesmentrestapi.service;
import com.asesmentrestapi.payload.PersonDTO;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class PersonService {


    // Method to generate a list of random persons using Stream API
    public List<PersonDTO> generateRandomPersons() {
        return IntStream.rangeClosed(1, 5) // Generating 5 random persons for demonstration
                .mapToObj(this::generateRandomPerson)
                .collect(Collectors.toList());
    }
    // Method to get a randomly generated person by ID using Stream API and ModelMapper
    public PersonDTO getRandomPersonById(int randomId) {
        return generateRandomPersons().stream()
                .filter(personDTO -> personDTO.getId() == randomId)
                .findFirst()
                .orElse(null);
    }

    // Method to generate a random person
    public PersonDTO generateRandomPerson(int id) {
        Random random = new Random();

        String[] names = {"John", "Jane", "Michael", "Emily", "William", "Olivia", "James", "Sophia"};
        String[] sexes = {"Male", "Female"};
        String[] addresses = {"123 Main St", "456 Park Ave", "789 Elm Rd", "101 Oak Dr"};

        String name = names[random.nextInt(names.length)];
        int age = random.nextInt(80) + 1; // Age between 1 and 80
        String sex = sexes[random.nextInt(sexes.length)];
        int mobileNumber = 100000000 + random.nextInt(900000000); // 9-digit random mobile number
        String address = addresses[random.nextInt(addresses.length)];

        PersonDTO personDTO = new PersonDTO(id, name, age, sex, mobileNumber, address);
        return personDTO;
    }


}
