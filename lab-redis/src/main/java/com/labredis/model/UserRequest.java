package com.labredis.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class UserRequest implements Serializable {

    private String name;

    private long followers;
}
