package com.mikkel.postgresExample.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

//We use capital staring letters to get their object version, meaning we can set their value to null
public class Author {
    private Long id;

    private String name;

    private Integer age;
}
