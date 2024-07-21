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
@Table(name = "tbl_admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String adress;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private byte deleted=0;
}
