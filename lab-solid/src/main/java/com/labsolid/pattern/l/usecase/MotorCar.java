package com.labsolid.pattern.l.usecase;

import com.labsolid.pattern.l.domain.Engine;
import com.labsolid.pattern.l.gateway.Car;

public class MotorCar extends Engine implements Car {

    @Override
    public void turnOnEngine() {
        super.on();
    }

    @Override
    public void accelerate() {
        super.powerOn(1_000);
    }
}
