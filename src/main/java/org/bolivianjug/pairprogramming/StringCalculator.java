package org.bolivianjug.pairprogramming;

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
        for (String number : numbers) {
            result += Integer.parseInt(number);
        }
        return result;
    }
}
