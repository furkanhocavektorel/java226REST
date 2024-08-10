package com.vektorel.restful.entity;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class City extends BaseEntity{
    private String name;
    // mantıksal ilişki
    private Long countryId;
}
