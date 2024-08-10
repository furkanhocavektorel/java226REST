package com.vektorel.restful.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminResponseDto {
    private Long id;
    private String name;
    private String surname;
}
