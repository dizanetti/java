package com.labsolid.pattern.l.usecase;

import com.labsolid.pattern.l.gateway.Car;
import org.springframework.stereotype.Component;

@Component
public class UseCar {

    public void use(Car car) {
        car.turnOnEngine();
        car.accelerate();
    }
}
