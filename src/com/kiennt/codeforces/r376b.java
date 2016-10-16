package com.kiennt.codeforces;

import java.io.*;
import java.util.StringTokenizer;

public class r376b {
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

    public static String solution(int[] a) {
        boolean useCoupon = false;
        for (int item: a) {
            if (useCoupon && item < 1) {
                return "NO";
            }
            item = item % 2;

            if (useCoupon) {
                useCoupon = item == 0;
            } else {
                useCoupon = item == 1;
            }
        }

        if (useCoupon) {
            return "NO";
        } else {
            return "YES";
        }
    }

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = sc.nextInt();
        }
        pw.println(solution(a));
        pw.close();
    }
}

