package com.send.sms.message.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PhoneNumber {

    @NotNull(message = "Country not null")
    private Long country;

    @NotNull(message = "Phone not null")
    private Long phone;
}
