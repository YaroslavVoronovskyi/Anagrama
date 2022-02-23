package com.gmail.voronovskyi.yaroslav.anagrams;

import java.util.StringJoiner;

public class AnagramService {
    public static final String DELIMETER = " ";

    public String createAnagram(String expression) {
        StringJoiner stringJoiner = new StringJoiner(DELIMETER);
        String[] expressionArray = expression.split(DELIMETER);
        for (String word : expressionArray) {
            stringJoiner.add(convertWord(word));
        }
        return stringJoiner.toString();
    }

    public String convertWord(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            return expression;
        }
        char[] charExpressionArray = expression.toCharArray();
        int startIndex = 0;
        int endIndex = expression.length() - 1;
        while (startIndex <= endIndex) {
            if (!Character.isAlphabetic(charExpressionArray[startIndex])) {
                startIndex++;
            } else if (!Character.isAlphabetic(charExpressionArray[endIndex])) {
                endIndex--;
            } else {
                char temp = charExpressionArray[startIndex];
                charExpressionArray[startIndex] = charExpressionArray[endIndex];
                charExpressionArray[endIndex] = temp;
                endIndex--;
                startIndex++;
            }
        }
        return String.valueOf(charExpressionArray);
    }
}
