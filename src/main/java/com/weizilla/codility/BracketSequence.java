package com.weizilla.codility;

public class BracketSequence
{
    public static int solution(String S, int K)
    {
        // write your code in Java SE 8
        System.out.println(isValid(S));
        return 0;
    }

    private static boolean isValid(String s)
    {
        int numOpen = 0;
        int numClose = 0;
        for (byte b : s.getBytes())
        {
            if (b == '(')
            {
                numOpen++;
            }
            else
            {
                numClose++;
            }
        }
        return numOpen == numClose;
    }

    public static void main(String[] args)
    {
        System.out.println(solution(")()()(", 3));
    }
}
