package com.gmail.voronovskyi.yaroslav.anagrams;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AnagramServiceTest {

    private AnagramService anagramService = new AnagramService();

    @Test
    public void convertWordShouldReturnNullWhenInputContainsNull() {
        assertEquals(null, anagramService.convertWord(null));
    }

    @Test
    public void convertWordShouldReturnGapWhenInputContainsGap() {
        assertEquals(" ", anagramService.convertWord(" "));
    }

    @Test
    public void createAnagramdShouldReturnOneLetterToLowerCaseWhenInputContainsOneLetterToLower() {
        assertEquals("a", anagramService.createAnagram("a"));
    }

    @Test
    public void createAnagramdShouldReturnFewLetterToLowerCaseWhenInputContainsFewLetterToLowerCase() {
        assertEquals("aaa", anagramService.createAnagram("aaa"));
    }

    @Test
    public void createAnagramdShouldReturnReversOneWordWhenInputContainsOneWord() {
        assertEquals("java", anagramService.createAnagram("avaj"));
    }

    @Test
    public void createAnagramdShouldReversLettersWithDifferentCaseWhenInputContainsLettersWithDifferentCase() {
        assertEquals("ааааААааАаА",
                anagramService.createAnagram("АаАааААаааа"));
    }

    @Test
    public void createAnagramdShoulReturnSpecialCharactersWithoutReversWhenInputContainsSpecialCharacters() {
        assertEquals("#@)₴?$0", anagramService.createAnagram("#@)₴?$0"));
    }

    @Test
    public void createAnagramdShoulReturnReversOneWordWithoutReversSpecialCharactersWhenInputContainsOneWordWithSpecialCharacters() {
        assertEquals("qwe1rty!", anagramService.createAnagram("ytr1ewq!"));
    }

    @Test
    public void createAnagramdShoulReturnReversAnyExpressionWithoutReversSpecialCharactersWhenInputContainsAnyExpressionWithSpecialCharacters() {
        String expected = "JUnit 5, the next generation of JUnit, facilitates writing developer tests with new and shiny features.";
        String actual = "tinUJ 5, eht txen noitareneg fo tinUJ, setatilicaf gnitirw repoleved stset htiw wen dna ynihs serutaef.";
        assertEquals(expected, anagramService.createAnagram(actual));
    }

    @ParameterizedTest
    @CsvSource({"a,a", "aaa,aaa", "java,avaj", "ааааААааАаА,АаАааААаааа"})
    void createAnagramdShouldReturnReversSimpleExpressionWithoutSpecialCharacters(
            String expected, String actual) {
        assertEquals(expected, anagramService.createAnagram(actual));
    }

    @ParameterizedTest
    @CsvSource(value = {"qwe1rty!:ytr1ewq!", "Hello world!:olleH dlrow!",
            "JUnit 5, the next generation of JUnit, facilitates writing developer tests with new and shiny features."
         + ":tinUJ 5, eht txen noitareneg fo tinUJ, setatilicaf gnitirw repoleved stset htiw wen dna ynihs serutaef."}, delimiter = ':')
    void createAnagramdShouldReturnReversDiferentExpressionWithSpecialCharacters(
            String expected, String actual) {
        assertEquals(expected, anagramService.createAnagram(actual));
    }
}
