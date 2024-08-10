package com.vektorel.restful.entity;

import com.vektorel.restful.entity.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String password;
    private String email;
}