package com.kiennt.codeforces;

import java.io.*;
import java.util.StringTokenizer;

public class r377c {
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

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
        long b = sc.nextLong();
        long d = sc.nextLong();
        long s = sc.nextLong();
        long result = 0;
        if (b >= d && b >= s) {
            if (b == d) {
                result = Math.max(b - 1 - s, 0);
            } else if (b == s) {
                result = Math.max(b - d - 1, 0);
            } else {
                result = Math.max(b - 1 - d, 0) + Math.max(b - 1 - s, 0);
            }
        } else if (s > b & s >= d) {
            if (s == d) {
                result = Math.max(s - 1 - b, 0);
            } else {
                result = Math.max(s - 1 - b, 0) + Math.max(s - 1 - d, 0);
            }
        } else {
            result = Math.max(d - b - 1, 0) + Math.max(d - s - 1, 0);
        }
        pw.println(result);
        pw.close();
    }
}
