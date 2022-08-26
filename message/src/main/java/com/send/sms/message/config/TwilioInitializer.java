package com.send.sms.message.config;

import com.twilio.Twilio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class TwilioInitializer {

    @Autowired
    private MessageConfig messageConfig;

    @Bean
    public void TwilioInit() {
        Twilio.init(messageConfig.getAccountSid(), messageConfig.getAuthToken());

        log.info("twilio Initialized with ... " + messageConfig.getAccountSid());
    }
}
