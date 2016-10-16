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


public class MdollsTest {

    @Test
    public void testSolution1() {
        assertEquals(2, Mdolls.solution(new Mdolls.Doll[]{
                new Mdolls.Doll(20, 30),
                new Mdolls.Doll(20, 20),
                new Mdolls.Doll(40, 50),
                new Mdolls.Doll(30, 40),
        }));
    }

    @Test
    public void testSolution2() {
        assertEquals(2, Mdolls.solution(new Mdolls.Doll[]{
                new Mdolls.Doll(20, 30),
                new Mdolls.Doll(10, 10),
                new Mdolls.Doll(30, 20),
                new Mdolls.Doll(40, 50),
        }));
    }

    @Test
    public void testSolution3() {
        assertEquals(3, Mdolls.solution(new Mdolls.Doll[]{
                new Mdolls.Doll(10, 30),
                new Mdolls.Doll(20, 20),
                new Mdolls.Doll(30, 10),
        }));
    }

    @Test
    public void testSolution4() {
        assertEquals(2, Mdolls.solution(new Mdolls.Doll[]{
                new Mdolls.Doll(10, 10),
                new Mdolls.Doll(20, 30),
                new Mdolls.Doll(40, 50),
                new Mdolls.Doll(39, 51),
        }));
    }

    @Test
    public void testSolution5() {
        assertEquals(3, Mdolls.solution(new Mdolls.Doll[]{
                new Mdolls.Doll(10, 10),
                new Mdolls.Doll(10, 30),
                new Mdolls.Doll(10, 10),
                new Mdolls.Doll(20, 30),
                new Mdolls.Doll(20, 30),
                new Mdolls.Doll(40, 50),
                new Mdolls.Doll(39, 51),
                new Mdolls.Doll(30, 50),
        }));
    }
}