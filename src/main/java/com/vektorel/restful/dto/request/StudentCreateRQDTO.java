package com.vektorel.restful.dto.request;

import com.vektorel.restful.entity.enums.Gender;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentCreateRQDTO {
    private String name;
    private String surname;
    private Gender gender;
    private String password;
    private String email;
}