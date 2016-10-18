package com.kiennt.codeforces;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class r376c {
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

    public static class Solution {
        int n, k, maxDuplicate, size;
        boolean[] isVisit;
        int[] socks;
        HashMap<Integer, Integer> counter;
        ArrayList<Integer>[] graphs;

        private void dfs(int node) {
            isVisit[node] = true;
            size++;
            int newValue = counter.getOrDefault(socks[node], 0) + 1;
            counter.put(socks[node], newValue);
            maxDuplicate = Math.max(maxDuplicate, newValue);
            for (int n: graphs[node]) {
                if (!isVisit[n]) dfs(n);
            }
        }

        public int solve() {
            isVisit = new boolean[n + 1];
            counter = new HashMap<>();

            int sum = 0;
            for (int i = 1; i <= n; ++i) {
                if (!isVisit[i]) {
                    counter.clear();
                    maxDuplicate = 0;
                    size = 0;
                    dfs(i);
                    sum += size - maxDuplicate;
                }
            }

            return sum;
        }

    }

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
        Solution s = new Solution();

        s.n = sc.nextInt();
        int m = sc.nextInt();
        s.k = sc.nextInt();
        s.graphs = Stream.generate(ArrayList::new).limit(s.n + 1).toArray(ArrayList[]::new);

        // init socks
        s.socks = new int[s.n + 1];
        for (int i = 1; i <= s.n; ++i)  {
            s.socks[i] = sc.nextInt();
        }

        // make graphs
        for (int i = 0; i < m; ++i) {
            int e1 = sc.nextInt();
            int e2 = sc.nextInt();
            s.graphs[e1].add(e2);
            s.graphs[e2].add(e1);
        }
        pw.print(s.solve());
        pw.close();
    }
}
