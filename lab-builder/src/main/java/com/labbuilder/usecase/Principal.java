package com.labbuilder.usecase;

import com.labbuilder.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Slf4j
@Service
public class Principal {

    @PostConstruct
    public void init() {

        //

        List<Teste> testes = Arrays.asList(
                new Teste(18L, new BigDecimal("10"), "P1"),
                new Teste(2L, new BigDecimal("10"), "P1"),
                new Teste(1L, new BigDecimal("9"), "P1"),
                new Teste(2L, new BigDecimal("11"), "P1"),
                new Teste(3L, new BigDecimal("10"), "P1"),
                new Teste(15L, new BigDecimal("10"), "P1")
        );

        AtomicReference<Long> comp = new AtomicReference<>();

        Map<Long, List<Teste>> test = testes.stream().sorted(Comparator.comparingLong(Teste::getPriority)).collect(Collectors.groupingBy(Teste::getPriority));

        test.keySet().stream().min(Comparator.comparingLong(Long::longValue)).ifPresent(l -> {
            if (test.get(l).size() > 1) {
                test.get(l).forEach(p -> {

                });
            } else {
                comp.set(test.get(l).get(0).getPriority());
            }
        });

        log.info(comp.toString());

        test.forEach((k, v) -> {
            log.info(k.toString());
            log.info(v.toString());

            if (v.size() > 1 ) {

            } else {

            }
        });

        //

        Person person = Person.builder()
                .age(36)
                .name("Diego")
                .occupation("Consultor")
                .occupation("Developer")
                .occupation("Consultor")
                .build();

        log.info(person.toString());
    }
}
