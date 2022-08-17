package org.bolivianjug.pairprogramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Created by julio.rocha on 17/8/22.
 *
 * @author julio.rocha
 */
class StringCalculatorTest {
    @Test
    @DisplayName("Sumar hasta 2 numeros, toda cadena vacia debe retornar 0")
    public void requrimiento1() {
        StringCalculator stringCalculator = new StringCalculator();
        Assertions.assertEquals(0, stringCalculator.add(""));
        Assertions.assertEquals(1, stringCalculator.add("1"));
        Assertions.assertEquals(3, stringCalculator.add("1,2"));
    }
    
}