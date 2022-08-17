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
        int result = 0;
        for (String number : numbers) {
            result += Integer.parseInt(number);
        }
        return result;
    }
}
