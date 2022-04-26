package com.labmapstruct.domain;

import lombok.*;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private Long id;

    private String name;

    private List<String> email;

    private Map<String, Address> address;
}
