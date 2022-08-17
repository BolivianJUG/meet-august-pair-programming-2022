package org.bolivianjug.pairprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by julio.rocha on 17/8/22.
 *
 * @author julio.rocha
 */
public class StringCalculator {

    public static final String DELIMITER_PREFIX = "//";
    public static final String BASE_DELIMITER = "[,\n]";

    public int add(String numbersInput) {
        if (numbersInput.isEmpty()) {
            return 0;
        }
        String[] numbers = getNumbers(numbersInput);
        List<String> negativeNumbers = new ArrayList<>();
        int result = exeteAddProcess(numbers, negativeNumbers);
        throwIfNegativeNumbersArePresent(negativeNumbers);
        return result;
    }

    private static String[] getNumbers(String numbersInput) {
        String effectiveDelimiter = BASE_DELIMITER;
        if (numbersInput.startsWith(DELIMITER_PREFIX)) {
            String[] split = numbersInput.split("\n");
            String customDelimiter = split[0].replace(DELIMITER_PREFIX, "");
            numbersInput = split[1];
            effectiveDelimiter = customDelimiter;
        }
        return numbersInput.split(effectiveDelimiter);
    }

    private static int exeteAddProcess(String[] numbers, List<String> negativeNumbers) {
        int result = 0;
        for (String number : numbers) {
            int value = Integer.parseInt(number);
            if (value < 0) {
                negativeNumbers.add(number);
            }
            result += value;
        }
        return result;
    }

    private static void throwIfNegativeNumbersArePresent(List<String> negativeNumbers) {
        if (!negativeNumbers.isEmpty()) {
            String numbersMessage = String.join(",", negativeNumbers);
            throw new NegativeNumber(numbersMessage);
        }
    }

    public static class NegativeNumber extends RuntimeException {
        public NegativeNumber(String numbersMessage) {
            super("Negativos no permitidos: " + numbersMessage);
        }
    }
}
