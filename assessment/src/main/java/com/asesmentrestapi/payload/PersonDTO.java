package com.asesmentrestapi.payload;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    private int id;
    private String name;
    private int age;
    private String sex;
    private int mobileNumber;
    private String address;

}
