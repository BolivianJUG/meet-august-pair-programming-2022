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
        String effectiveDelimiter = BASE_DELIMITER;
        if (numbersInput.startsWith(DELIMITER_PREFIX)) {
            String[] split = numbersInput.split("\n");
            String customDelimiter = split[0].replace(DELIMITER_PREFIX, "");
            numbersInput = split[1];
            effectiveDelimiter = customDelimiter;
        }
        String[] numbers = numbersInput.split(effectiveDelimiter);
        int result = 0;
        List<String> negativeNumbers = new ArrayList<>();
        for (String number : numbers) {
            int value = Integer.parseInt(number);
            if (value < 0) {
                negativeNumbers.add(number);
            }
            result += value;
        }
        if (!negativeNumbers.isEmpty()) {
            String numbersMessage = String.join(",", negativeNumbers);
            throw new NegativeNumber(numbersMessage);
        }
        return result;
    }

    public static class NegativeNumber extends RuntimeException {
        public NegativeNumber(String numbersMessage) {
            super("Negativos no permitidos: " + numbersMessage);
        }
    }
}
