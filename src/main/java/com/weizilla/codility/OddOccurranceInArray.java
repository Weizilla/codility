package com.weizilla.codility;

import java.util.HashSet;
import java.util.Set;

public class OddOccurranceInArray
{
    public static int solution(int[] A)
    {
        Set<Integer> unpaired = new HashSet<Integer>();
        for (int i : A)
        {
            if (unpaired.contains(i))
            {
                unpaired.remove(i);
            }
            else
            {
                unpaired.add(i);
            }
        }
        return unpaired.iterator().next();
    }

    public static void main(String[] args)
    {
        System.out.println(solution(new int[]{9, 3, 9, 3, 9, 7, 9}));
        System.out.println(solution(new int[]{1}));
        System.out.println(solution(new int[]{1, 1, 1, 1, 1, 1, 1}));
    }
}
