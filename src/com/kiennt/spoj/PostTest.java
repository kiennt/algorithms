package com.kiennt.spoj;

import com.kiennt.spoj.Post;
import junit.framework.TestCase;

/**
 * Created by knt on 10/15/16.
 */
public class PostTest extends TestCase {
    public void testSolution() throws Exception {
        assertEquals(3, Post.solution(1, 2));
    }
}