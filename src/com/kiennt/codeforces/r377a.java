package com.kiennt.codeforces;

import java.io.*;
import java.util.StringTokenizer;

public class r377a {
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

    public static int solution(int k, int r) {
        for (int i = 1; i <= 10; ++i) {
            int mod = (k * i ) % 10;
            if (mod == 0 || mod == r) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        MyScanner sc = new MyScanner();
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
        int k = sc.nextInt();
        int r = sc.nextInt();
        pw.println(solution(k, r));
        pw.close();
    }
}
