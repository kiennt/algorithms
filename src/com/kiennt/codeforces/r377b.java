package com.kiennt.codeforces;

import java.io.*;
import java.util.StringTokenizer;

public class r377b {
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public boolean hasNext() {
            if (st != null && st.hasMoreTokens())
                return true;
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                return false;
            }
            return true;
        }

        public String nextLine() {
            StringBuilder sb;
            try {
                while (st == null || !st.hasMoreTokens()) return br.readLine();
                sb = new StringBuilder(st.nextToken());
                while (st.hasMoreTokens()) sb.append(" " + st.nextToken());
            } catch (IOException e) {
                throw new RuntimeException();
            }
            return sb.toString();
        }

        public String next() {
            if (hasNext()) return st.nextToken();
            return null;
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
    }

    public static int solution(int[] a, int k) {
        int result = 0;
        int current = a[0];

        for (int i = 1; i < a.length; ++i) {
            int value = k - current;
            if (value > a[i]) {
                result += value - a[i];
                a[i] = value;
            }
            current = a[i];
        }

        return result;
    }

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = sc.nextInt();
        }
        int result = solution(a, k);
        pw.println(result);
        for (int i = 0; i < n; ++i) {
            if (i < n - 1) {
                pw.printf("%d ", a[i]);
            } else {
                pw.println(a[i]);
            }
        }
        pw.close();
    }
}
