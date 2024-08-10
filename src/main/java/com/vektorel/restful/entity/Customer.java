package com.vektorel.restful.entity;

import com.vektorel.restful.entity.enums.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Customer extends BaseEntity {

    private String name;
    private String surname;
    private String email;
    private String password;
    private int age;
    private Gender gender;

}
