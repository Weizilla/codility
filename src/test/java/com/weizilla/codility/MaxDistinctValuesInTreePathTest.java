package com.weizilla.codility;

import org.testng.annotations.Test;

import static com.weizilla.codility.MaxDistinctValuesInTreePath.solution;
import static org.assertj.core.api.Assertions.assertThat;

public class MaxDistinctValuesInTreePathTest
{
    @Test
    public void findTreeHeight() throws Exception
    {
        Tree g = new Tree("g", 5);
        Tree d = new Tree("d", 4, g, null);
        Tree b = new Tree("b", 5, d, null);
        Tree e = new Tree("e", 1);
        Tree f = new Tree("f", 6);
        Tree c = new Tree("c", 6, e, f);
        Tree a = new Tree("a", 4, b, c);

        assertThat(solution(a)).isEqualTo(3);
    }

    @Test
    public void handlesNullAndEmptyTrees() throws Exception
    {
        assertThat(solution(null)).isEqualTo(0);
        assertThat(solution(new Tree("a", 2))).isEqualTo(1);
    }

    @Test
    public void handlesSameValue() throws Exception
    {
        Tree g = new Tree("g", 1);
        Tree f = new Tree("f", 1);
        Tree e = new Tree("e", 1);
        Tree d = new Tree("d", 1);
        Tree c = new Tree("c", 1, f, g);
        Tree b = new Tree("b", 1, d, e);
        Tree a = new Tree("a", 1, b, c);

        assertThat(solution(a)).isEqualTo(0);
    }

    @Test
    public void handlesDiffValue() throws Exception
    {
        Tree g = new Tree("g", 7);
        Tree f = new Tree("f", 6);
        Tree e = new Tree("e", 5);
        Tree d = new Tree("d", 4);
        Tree c = new Tree("c", 3, f, g);
        Tree b = new Tree("b", 2, d, e);
        Tree a = new Tree("a", 1, b, c);

        assertThat(solution(a)).isEqualTo(3);
    }
}