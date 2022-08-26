package com.send.sms.message.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationPropertiesScan
@ConfigurationProperties(prefix = "twilio")
public class MessageConfig {

    private String trialNumber;

    private String authToken;

    private String accountSid;
}
