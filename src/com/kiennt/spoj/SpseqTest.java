package com.kiennt.spoj;

import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by knt on 10/16/16.
 */
public class SpseqTest {

    @Test
    public void testBuildLcs() {
        int[] a = new int[]{1, 2, 3, 4, 5, 4, 3, 2, 1, 10};
        int[] m = new int[a.length];
        int[] expectedInc = new int[]{1, 2, 3, 4, 5, 4, 3, 2, 1, 6};
        int[] expectedDes = new int[]{1, 2, 3, 4, 5, 4, 3, 2, 1, 1};
        assertArrayEquals(expectedDes, Spseq.buildLcsIndexDecrease(a, m));
        assertArrayEquals(expectedInc, Spseq.buildLcsIndexIncrease(a, m));
    }

    @Test
    public void testSolution1() throws Exception {
        assertEquals(9, Spseq.solution(new int[] {1, 2, 3, 4, 5, 4, 3, 2, 1, 10}));
    }

    @Test
    public void testSolution2() throws Exception {
        assertEquals(9, Spseq.solution(new int[] {1, 2, 3, 2, 1, 2, 3, 4, 3, 2, 1, 5, 4, 1, 2, 3, 2, 2, 1}));
    }

    @Test
    public void testPerformance() {
        int N = 100000;
        int maxI = 1000000000;
        int[] a = new int[N];
        for (int i = 0; i < N; ++i) {
            a[i] = ThreadLocalRandom.current().nextInt(0, maxI);
        }
        Spseq.solution(a);
    }
}