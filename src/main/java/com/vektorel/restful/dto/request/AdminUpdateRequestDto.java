package com.vektorel.restful.dto.request;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminUpdateRequestDto {
    private Long id;
    private String name;
    private String soyadi;
    private String sifre;
    private String adress;
}
