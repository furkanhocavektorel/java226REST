package com.vektorel.restful.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminSaveRequestDto {
    private String name;
    private String surname;
    private String email;
    private String password;
}
