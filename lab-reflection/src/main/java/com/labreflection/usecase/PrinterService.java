package com.labreflection.usecase;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Data
@Service
public class PrinterService {

    private String message;

    public PrinterService()  {  message = "HelloReflection"; }

    public void printMessage()  {
        log.info("The string is {}", message);
    }

    public void printNumber(int number)  {
        log.info("The number is {}", number);
    }

    private void printPrivateMessage() {
        log.info("Private method invoked");
    }
}
