package com.labmapstruct.dto;

import com.labmapstruct.domain.Address;
import lombok.*;

import java.util.List;
import java.util.Map;

@Data
public class PersonDto {

    private Long identification;

    private String name;

    private List<String> email;

    private Map<String, Address> addressList;
}
