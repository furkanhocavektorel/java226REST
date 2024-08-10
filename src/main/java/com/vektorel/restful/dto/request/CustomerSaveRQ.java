package com.vektorel.restful.dto.request;

import com.vektorel.restful.entity.enums.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerSaveRQ {
    private String name;
    private String surname;
    private String email;
    private String password;
}
