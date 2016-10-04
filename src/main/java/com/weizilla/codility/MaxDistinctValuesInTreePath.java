package com.weizilla.codility;

import java.util.HashSet;
import java.util.Set;

public class MaxDistinctValuesInTreePath
{
    public static int solution(Tree T)
    {
        if (T == null)
        {
            return 0;
        }

        if (isLeaf(T))
        {
            return 1;
        }

        return findMaxHeight(T, new HashSet<>(), 1);
    }

    private static boolean isLeaf(Tree node)
    {
        return node.l == null && node.r == null;
    }

    private static int findMaxHeight(Tree node, Set<Integer> values, int height)
    {
        values.add(node.x);
        if (isLeaf(node))
        {
            return values.size() == height ? height : 0;
        }

        int leftHeight = findHeight(node.l, values, height);
        int rightHeight = findHeight(node.r, values, height);
        return Math.max(leftHeight, rightHeight);
    }

    private static int findHeight(Tree node, Set<Integer> values, int height)
    {
        return node != null ? findMaxHeight(node, new HashSet<>(values), height + 1) : 0;
    }

    public static void main(String[] args)
    {
        Tree g = new Tree("g", 5);
        Tree d = new Tree("d", 4, g, null);
        Tree b = new Tree("b", 5, d, null);
        Tree e = new Tree("e", 1);
        Tree f = new Tree("f", 6);
        Tree c = new Tree("c", 6, e, f);
        Tree a = new Tree("a", 4, b, c);

        System.out.println(solution(a));
    }
}

class Tree
{
    public int x;
    public Tree l;
    public Tree r;
    public String id;

    public Tree(String id, int x)
    {
        this.id = id;
        this.x = x;
    }

    public Tree(String id, int x, Tree l, Tree r)
    {
        this.id = id;
        this.x = x;
        this.l = l;
        this.r = r;
    }
}
