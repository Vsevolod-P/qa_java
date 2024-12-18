package com.example;

import org.junit.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class CatTest {

    @Test
    public void testGetSound() {
        Feline mockCat = Mockito.mock(Feline.class);
        Cat cat = new Cat(mockCat);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        Feline mockCat = Mockito.mock(Feline.class);
        Cat cat = new Cat(mockCat);
        List<String> expectedFood = List.of("Животные", "Рыба");
        when(mockCat.eatMeat()).thenReturn(expectedFood);
        assertEquals(expectedFood, cat.getFood());
    }
}