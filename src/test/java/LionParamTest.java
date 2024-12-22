package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@RunWith(Parameterized.class)
public class LionParamTest {

    @Parameterized.Parameter
    public String sex;

    @Parameterized.Parameter(1)
    public Feline feline;

    @Parameterized.Parameter(2)
    public boolean expectedHasMane;


    @Parameterized.Parameters(name = "Lion(sex={0}, feline={1}) expectedHasMane={2}")
    public static Object[][] testData() {
        Feline mockFeline = mock(Feline.class);
        return new Object[][]{
                {"Самец", mockFeline, true},
                {"Самка", mockFeline, false}
        };
    }

    @Test
    public void lionHasManeTest() throws Exception {
            Lion lion = new Lion(sex, feline);
            assertEquals(expectedHasMane, lion.doesHaveMane());
    }
}
