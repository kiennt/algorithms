/**
 http://vn.spoj.com/problems/POST/
 Cho 2 số nguyên A và B . Hãy tính A + B .

 Input
 Gồm 1 dòng chứa 2 số nguyên A và B , cách bởi 1 dấu cách.

 Output
 Ghi ra tổng A+B .

 Ví dụ
 Input:
 3 4

 Output:
 7
 */
package com.kiennt.spoj;

import java.io.*;
import java.util.StringTokenizer;

public class Post {

    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static int solution(int a, int b) {
        return a + b;
    }

    public static void main (String[] args) {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int a = sc.nextInt();
        int b = sc.nextInt();
        out.println(solution(a, b));
        out.close();
    }
}
