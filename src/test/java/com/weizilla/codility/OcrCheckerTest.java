package com.weizilla.codility;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OcrCheckerTest
{
    @DataProvider(name = "strings")
    public static Object[][] strings()
    {
        return new Object[][]
            {
                new Object[]{"A2Le", "2pL1", true},
                new Object[]{"a10", "10a", true},
                new Object[]{"ba1", "1Ad", false},
                new Object[]{"3x2x", "8", false},
                new Object[]{"aaaa", "bbbb", false},
                new Object[]{"a3a", "ab1ba", true},
            };
    }

    @Test(dataProvider = "strings")
    public void testName(String a, String b, boolean expected) throws Exception
    {
        boolean actual = OcrChecker.solution(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}