package com.labsolid.pattern.s;

import com.labsolid.pattern.s.usecase.TextManipulator;
import com.labsolid.pattern.s.usecase.TextPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainS {

    @Autowired
    private TextManipulator textManipulator;

    @Autowired
    private TextPrinter textPrinter;

    /**
     * SRP = Single Responsibility Principle
     * <p>
     * The name of the principle says it all: “One class should have one and only one responsibility”
     * <p>
     * In other words, we should write, change and maintain a class for only one purpose. If it is model class then it
     * should strictly represent only one actor/ entity. This will give we the flexibility to make changes in future
     * without worrying the impacts of changes for another entity.
     */
    public void start() {
        textManipulator.setText("Diego Zanetti");
        textPrinter.printText();

        textManipulator.findWordAndDelete("Zanetti");
        textPrinter.printText();
    }
}
