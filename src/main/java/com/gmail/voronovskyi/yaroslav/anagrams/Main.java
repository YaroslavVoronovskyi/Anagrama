package com.gmail.voronovskyi.yaroslav.anagrams;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter expression: ");
        String expression = scanner.nextLine();
        System.out.println("Original expression: " + expression);
        AnagramService anagramService = new AnagramService();
        System.out.println("Reversed expression: " + anagramService.createAnagram(expression));
        scanner.close();
    }
}
