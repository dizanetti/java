package com.send.sms.message.usecases;

import com.send.sms.message.config.MessageConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

@Slf4j
@Service
public class MessageService {

    @Autowired
    private MessageConfig messageConfig;

    private static final String MESSAGE = "Hello Diego, sent sms with successful";

    public String sendSMS(Long country, Long phone) {

        final String phoneTo = "+" + country + phone;

        MessageCreator creator = new MessageCreator( new PhoneNumber(phoneTo), new PhoneNumber(messageConfig.getTrialNumber()), MESSAGE);
        try {
            creator.create();

            return "SMS Sent Successfully to the provided number";
        }
        catch (Exception e) {
            log.error("Something went wrong: {}", e.getMessage());
        }
        return "SMS Couldn't be sent";
    }
}
