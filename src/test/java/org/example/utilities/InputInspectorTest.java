package org.example.utilities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.example.utilities.InputInspector.*;

class InputInspectorTest {

    @Test
    void legendInputReturnsOneIfStringIsBlank(){
        assertEquals(1, legendInput(""));
    }

    @Test
    void numOfLettersInputReturnsOneIfStringIsBlank(){
        assertEquals(1, numOfLettersInput(""));
    }

    @Test
    void wordInputReturnsOneIfStringIsBlank(){
        assertEquals(1, wordInput(""));
    }

    @Test
    void legendInputReturnsTwoIfStringContainsANumber(){
        assertEquals(2, legendInput("Hi there 3"));
    }

    @Test
    void legendInputReturnsTwoIfStringContainsASpecialCharacter(){
        assertEquals(2, legendInput("Speciální znak /"));
    }

    @Test
    void legendInputReturnsTwoIfItContainsTab(){
        assertEquals(2, legendInput(" Hello\t hello again"));
    }

    @Test
    void legendInputReturnsTwoIfItContainsNewline(){
        assertEquals(2, legendInput(" Hello\n hello again"));
    }

    @Test
    void numOfLettersInputReturnsTwoIfStringContainsACharacter(){
        assertEquals(2, numOfLettersInput("9A"));
    }

    @Test
    void numOfLettersInputReturnsTwoIfStringContainsASpecialCharacter(){
        assertEquals(2, numOfLettersInput("6@"));
    }

    @Test
    void numOfLettersInputReturnsTwoIfStringContainsAWhitespaceCharacterSpace(){
        assertEquals(2, numOfLettersInput(" 5"));
    }

    @Test
    void numOfLettersInputReturnsTwoIfStringContainsAWhitespaceCharacterTab(){
        assertEquals(2, numOfLettersInput("4\t"));
    }

    @Test
    void numOfLettersInputReturnsTwoIfStringContainsAWhitespaceCharacterNewline(){
        assertEquals(2, numOfLettersInput("7\n"));
    }

    @Test
    void wordInputReturnsTwoIfStringContainsANumber(){
        assertEquals(2, wordInput("Number7numBer"));
    }

    @Test
    void wordInputReturnsTwoIfStringContainsASpecialCharacter(){
        assertEquals(2, wordInput("Special^Character"));
    }

    @Test
    void wordInputReturnsTwoIfStringContainsAWhitespaceCharacterSpace(){
        assertEquals(2, wordInput("White Space"));
    }

    @Test
    void wordInputReturnsTwoIfStringContainsAWhitespaceCharacterTab(){
        assertEquals(2, wordInput("White\tSpace"));
    }

    @Test
    void wordInputReturnsTwoIfStringContainsAWhitespaceCharacterNewline(){
        assertEquals(2, wordInput("White\nSpace"));
    }

    @Test
    void legendInputReturnsThreeIfStringIsTooLong(){
        assertEquals(3, legendInput("I am long I am long I am long I am long I am long I am long I am long I am long I am long I am long I am long I am long I am long I am long I am long I am long I am long I am long I am long I am long "));
    }

    @Test
    void numOfLettersInputReturnsThreeIfStringIsTooLong(){
        assertEquals(3, numOfLettersInput("123"));
    }

    @Test
    void wordInputReturnsThreeIfStringIsTooLong(){
        assertEquals(3, wordInput("IamLongstrIamLongstrIamLongstrIamLongstrIamLongstrIamLongstrIamLongstrIamLongstrIamLongstrIamLongstrIamLongstrIamLongstrIamLongstrIamLongstrIamLongstrIamLongstrIamLongstrIamLongstrIamLongstrIamLongstr"));
    }

    @Test
    void legendInputReturnsZeroIfItContainsCzechSpecialCharacters(){
        assertEquals(0, legendInput("ěščřžýáíéňťúůóďĚŠČŘŽÝÁÍÉŮÚĎŤÓŇ hello"));
    }

    @Test
    void wordInputReturnsZeroIfItContainsCzechSpecialCharacters(){
        assertEquals(0, wordInput("ěščřžýáíéňťúůóďĚŠČŘŽÝÁÍÉŮÚĎŤÓŇhello"));
    }
    
}