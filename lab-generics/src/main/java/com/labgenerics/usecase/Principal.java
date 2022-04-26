package com.labgenerics.usecase;

import com.labgenerics.domain.MyGenericClass;
import com.labgenerics.domain.MyGenericClassComp;
import com.labgenerics.domain.MyGenericCompareTo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class Principal {

    @PostConstruct
    public void init() {
        MyGenericClass<Integer> integerMyGenericClass = new MyGenericClass<>();
        integerMyGenericClass.setObj(5);

        MyGenericClass<String> stringMyGenericClass = new MyGenericClass<>();
        stringMyGenericClass.setObj("Hello Generics");

        log.info("Member of MyGenericClass<Integer>: {}", integerMyGenericClass.getObj());
        log.info("Member of MyGenericClass<String>: {}", stringMyGenericClass.getObj());

        MyGenericClassComp<Integer, String> classComp = new MyGenericClassComp<>(1, "Hello");
        classComp.print();

        int compareTo = MyGenericCompareTo.compareTo("bla", "bla");

        log.info("Result of compare two strings: {}", compareTo);
    }
}
