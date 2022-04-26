package com.labreflection.usecase;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
@Service
public class Principal {

    @Autowired
    private PrinterService printerService;

    @PostConstruct
    public void init() throws NoSuchMethodException, NoSuchFieldException, InvocationTargetException, IllegalAccessException {

        Class cls = printerService.getClass();
        log.info("The name of class is {}", cls.getName());

        Constructor constructor = cls.getConstructor();
        log.info("The name of constructor is {}", constructor.getName());

        log.info("The public methods of class are : ");
        Method[] methods = cls.getMethods();

        for (Method method : methods)
            log.info(method.getName());

        Method methodCall1 = cls.getDeclaredMethod("printNumber", int.class);
        methodCall1.invoke(printerService, 19);

        Method methodCall2 = cls.getDeclaredMethod("printMessage");
        methodCall2.invoke(printerService);

        Field field = cls.getDeclaredField("message");
        field.setAccessible(true);
        field.set(printerService, "JAVA");

        methodCall2.invoke(printerService);

        Method methodCall3 = cls.getDeclaredMethod("printPrivateMessage");
        methodCall3.setAccessible(true);
        methodCall3.invoke(printerService);

    }
}
