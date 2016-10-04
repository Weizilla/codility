package com.weizilla.codility;

public class BinaryGap
{
    public static int solution(int N)
    {
        byte[] bytes = Integer.toBinaryString(N).getBytes();
        int oneIndex = 0;
        int maxLength = 0;

        for (int i = 0; i < bytes.length; i++)
        {
            if (bytes[i] == '1')
            {
                maxLength = Math.max(maxLength, i - oneIndex);
                oneIndex = i;
            }
        }
        return maxLength - 1;
    }

    public static void main(String[] args)
    {
        System.out.println(solution(1041));
    }
}
