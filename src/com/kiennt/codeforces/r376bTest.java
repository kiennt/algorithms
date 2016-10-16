package com.kiennt.codeforces;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by knt on 10/16/16.
 */
public class r376bTest {

    @Test
    public void testSolution1() {
        assertEquals("YES", r376b.solution(new int[]{1, 2, 1, 2}));
    }

    @Test
    public void testSolution2() {
        assertEquals("NO", r376b.solution(new int[]{1, 0, 1}));
    }

    @Test
    public void testSolution3() {
        assertEquals("YES", r376b.solution(new int[]{1, 4, 5, 7, 9}));
    }
}