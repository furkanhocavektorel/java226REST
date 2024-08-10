package com.vektorel.restful.dto.response;

import com.vektorel.restful.entity.enums.Gender;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO {
    private Long id;
    private String name;
    private String surname;
    private Gender gender;
    private String password;
    private String email;
}
