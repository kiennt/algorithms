package com.kiennt.spoj;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by knt on 10/16/16.
 */
public class QbdivseqTest {

    @Test
    public void testSolution1() {
        assertEquals(2, Qbdivseq.solution(new int[] {1, 5, 4, 6}));
    }

    @Test
    public void testSolution2() {
        assertEquals(3, Qbdivseq.solution(new int[] {1, 2, 4, 3, 4, 4, 1}));
    }

    @Test
    public void testSolution3() {
        assertEquals(3, Qbdivseq.solution(new int[] {1, 2, 4, 5, 3, 4, 1}));
    }

    @Test
    public void testPerformance() {
        int N = 10000;
        int[] a = new int[N];
        int maxI = 1000000000;
        for (int i = 0; i < N; ++i) {
            a[i] = ThreadLocalRandom.current().nextInt(0, maxI);
        }
        Qbdivseq.solution(a);
    }
}