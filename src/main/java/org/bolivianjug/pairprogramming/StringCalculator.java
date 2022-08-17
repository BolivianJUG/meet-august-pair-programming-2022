package org.bolivianjug.pairprogramming;

/**
 * Created by julio.rocha on 17/8/22.
 *
 * @author julio.rocha
 */
public class StringCalculator {
    public int add(String numbersInput) {
        if (numbersInput.isEmpty()) {
            return 0;
        }
        String[] numbers = numbersInput.split(",");
        if (numbers.length > 1) {
            return Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
        }
        return Integer.parseInt(numbersInput);
    }
}
