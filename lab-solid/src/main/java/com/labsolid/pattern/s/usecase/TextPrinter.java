package com.labsolid.pattern.s.usecase;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
@AllArgsConstructor
public class TextPrinter {

    private TextManipulator textManipulator;

    public void printText() {
        log.info(textManipulator.getText());
    }

    public void printOutEachWordOfText() {
        log.info(Arrays.toString(textManipulator.getText().split(" ")));
    }

    public void printRangeOfCharacters(int startingIndex, int endIndex) {
        log.info(textManipulator.getText().substring(startingIndex, endIndex));
    }
}
