package com.vektorel.restful.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class District extends BaseEntity{
    private String name;
    private Long cityId;
}
