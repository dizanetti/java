package com.labsolid.pattern.l;

import com.labsolid.pattern.l.usecase.ElectricCar;
import com.labsolid.pattern.l.usecase.MotorCar;
import com.labsolid.pattern.l.usecase.UseCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainL {

    @Autowired
    private UseCar useCar;

    /**
     * LSP = Liskov Substitution Principle
     *
     * Ex: Se nada como um pato, voa como um pato, porém precisa de baterias, provavelmente você possui um problema de abstração.
     *
     * This principle suggests that “parent classes should be easily substituted with their child classes without
     * blowing up the application”. Simply put, if class A is a subtype of class B, then we should be able to replace B
     * with A without disrupting the behavior of our program.
     */
    public void start() {
        MotorCar motorCar = new MotorCar();
        ElectricCar electricCar = new ElectricCar();

        useCar.use(motorCar);

        /**
         * Ao utilizar o carro eletrico, o codigo gera um erro por não ter o mesmo comportamento de um carro a combustão,
         * portanto em sua abstração ouve um erro de analise. Isso não era pra acontecer ao utilizar o principio de Liskov
         */
        useCar.use(electricCar);
    }
}
