package com.vektorel.restful.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AdminResponseDto {
    private Long id;
    private String name;
    private String surname;
}
