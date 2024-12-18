package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionParamTest {

    @Parameterized.Parameter
    public String sex;

    @Parameterized.Parameter(1)
    public boolean expectedHasMane;


    @Parameterized.Parameters(name = "Lion(sex={0}) expectedHasMane={1}")
    public static Object[][] testData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void lionHasManeTest() throws Exception {
            Lion lion = new Lion(sex);
            assertEquals(expectedHasMane, lion.doesHaveMane());
    }
}
