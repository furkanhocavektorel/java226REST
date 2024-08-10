package com.vektorel.restful.entity;

import com.vektorel.restful.entity.enums.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "tbl_admin")
public class Admin extends BaseEntity {

    private String name;
    private String surname;
    private String email;
    private String password;
    private String adress;
    @Enumerated(EnumType.STRING)
    private Gender gender;

}
