package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class LionTest {

    private Feline mockFeline;
    private Lion lion;

    @Before
    public void setUp() {
        mockFeline = Mockito.mock(Feline.class);
    }

    @Test
    public void lionHasManeTest() throws Exception {
        lion = new Lion("Самец");
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void lionHasNotManeTest() throws Exception {
        lion = new Lion("Самка");
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void testGetKittens() {
        when(mockFeline.getKittens()).thenReturn(1);
        lion = new Lion(mockFeline);
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = List.of("Птицы","Рыба");
        when(mockFeline.getFood("Хищник")).thenReturn(expectedFood);
        lion = new Lion(mockFeline);
        assertEquals(expectedFood, lion.getFood());
    }

    @Test
    public void testLionThrowsExceptionForInvalidSex() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Неправильный пол");
        });

        String expectedMessage = "Используйте допустимые значения пола животного - самец или самка";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}