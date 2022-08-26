package com.lab.javastream.usecase;

import com.lab.javastream.usecase.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Service
public class JavaStream {

    @PostConstruct
    public void streams() {

        forEach();
        map();

        // collect
        List<Employee> employees = returnNewEmployee();

        String names = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", "));
        log.info(names);

        Map<String, Integer> newMap = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toMap(Function.identity(), String::length));
        newMap.forEach((key, value) -> {
            log.info("Name: {} with length: {}", key, value);
        });
    }

    private void map() {
        List<Employee> employees = returnNewEmployee();

        employees.stream()
                .map(Employee::getId)
                .collect(Collectors.toList())
                .forEach(i -> log.info("Id's: {}", i));
    }

    private void forEach() {
        List<Employee> employees = returnNewEmployee();

        employees.forEach(e -> log.info(e.getName()));
    }

    private List<Employee> returnNewEmployee() {
        return Arrays.asList(new Employee(1L, "Jeff Bezos", new BigDecimal(10_000_00)),
                new Employee(2L, "Bill Gates", new BigDecimal(20_000_00)),
                new Employee(3L, "Mark Zuckerberg", new BigDecimal(30_000_00)));
    }
}
