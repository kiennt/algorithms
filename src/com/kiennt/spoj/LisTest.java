package com.kiennt.spoj;

import junit.framework.TestCase;

/**
 * Created by knt on 10/15/16.
 */
public class LisTest extends TestCase {
    public void testSolution1() throws Exception {
        assertEquals(3, Lis.solution(new long[]{2, 7, 4, 3, 8}));
    }

    public void testSolution2() throws Exception {
        assertEquals(3, Lis.solution(new long[]{3, 2, 6, 4, 5, 1}));
    }

    public void testSolution3() throws Exception {
        assertEquals(8, Lis.solution(new long[] {1, 20, 30, 2, 3, 4, 5, 6, 90, 70, 30, 40}));
    }

    public void testSolution4() throws Exception {
        assertEquals(5, Lis.solution(new long[] {5, 4, 4, 4, 5, 6, 7, 4, 4, 4, 5, 6, 7, 8}));
    }
}