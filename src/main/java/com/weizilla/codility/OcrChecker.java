package com.weizilla.codility;

import java.util.ArrayList;
import java.util.List;

public class OcrChecker
{
    public static boolean solution(String S, String T)
    {
        List<Character> sExpanded = expandWithUnknowns(S);
        List<Character> tExpanded = expandWithUnknowns(T);
        return isSame(sExpanded, tExpanded);
    }

    private static List<Character> expandWithUnknowns(String s)
    {
        List<Character> expandedChars = new ArrayList<>();
        List<Character> unknownDigits = new ArrayList<>();
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (Character.isLetter(c))
            {
                addUnknownChars(expandedChars, unknownDigits);
                expandedChars.add(c);
            }
            else
            {
                unknownDigits.add(c);
            }
        }
        addUnknownChars(expandedChars, unknownDigits);
        return expandedChars;
    }

    private static void addUnknownChars(List<Character> expanded, List<Character> unknownDigits)
    {
        if (! unknownDigits.isEmpty())
        {
            int numUnknowns = toNumber(unknownDigits);
            for (int i = 0; i < numUnknowns; i++)
            {
                expanded.add('?');
            }
            unknownDigits.clear();
        }
    }

    private static int toNumber(List<Character> charList)
    {
        char[] chars = new char[charList.size()];
        for (int i = 0; i < charList.size(); i++)
        {
            chars[i] = charList.get(i);
        }
        return Integer.valueOf(new String(chars));
    }

    private static boolean isSame(List<Character> s, List<Character> t)
    {
        if (s.size() != t.size())
        {
            return false;
        }

        for (int i = 0; i < s.size(); i++)
        {
            char sChar = s.get(i);
            char tChar = t.get(i);
            if (sChar != tChar && sChar != '?' && tChar != '?')
            {
                return false;
            }
        }
        return true;
    }
}
