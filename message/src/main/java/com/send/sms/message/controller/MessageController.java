package com.send.sms.message.controller;

import com.send.sms.message.entity.PhoneNumber;
import com.send.sms.message.usecases.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping
    public String sendSMS(@RequestBody PhoneNumber request) {
        return messageService.sendSMS(request.getCountry(), request.getPhone());
    }
}
