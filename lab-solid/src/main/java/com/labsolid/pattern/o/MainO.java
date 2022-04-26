package com.labsolid.pattern.o;

import com.labsolid.pattern.o.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class MainO {

    /**
     * OCP = Open Closed Principle
     *
     * Open closed principle states: “Software components should be open for extension, but closed for modification”.
     * This is second important rule which we should keep in mind while designing our application.
     *
     * What does this mean?? This means that our classes should be designed such a way that whenever fellow developers
     * wants to change the flow of control in specific conditions in application, all they need to extend our class
     * and override some functions and that’s it.
     */
    public void start() {
        Employee employee = new Employee();
        employee.setAge(35);
        employee.setFirstName("Diego");
        employee.setLastName("Zanetti");

        /**
         * Foi sobrescrito o metodo welcomeMessage na classe Employee, pois ela extend a classe Person.
         */
        employee.welcomeMessage();
    }
}
