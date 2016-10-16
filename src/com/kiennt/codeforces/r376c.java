package com.kiennt.codeforces;

import java.io.*;
import java.util.*;

public class r376c {
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

    private static int dfs(ArrayList<List<Integer>> graphs, boolean[] isVisit, int node) {
        int size = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            node = stack.pop();
            if (isVisit[node]) {
                continue;
            }
            isVisit[node] = true;
            size++;
            for (int nextNode: graphs.get(node)) {
                stack.push(nextNode);
            }
        }

        return size;
    }

    public static int solution(ArrayList<List<Integer>> graphs, int[] socks) {
        boolean[] isVisit = new boolean[socks.length];
        int sum = 0;

        for (int i = 1; i < socks.length; ++i) {
            int size = dfs(graphs, isVisit, i);
            if (size > 0) {
                sum += size - 1;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
        int n = sc.nextInt();
        int m = sc.nextInt();

        // init graph
        int k = sc.nextInt();
        ArrayList<List<Integer>> graphs = new ArrayList<List<Integer>>(n + 1);
        for (int i = 0; i <= n; ++i) {
            List<Integer> list = new LinkedList<>();
            graphs.add(i, list);
        }

        // init socks
        int[] socks = new int[n + 1];
        for (int i = 1; i <= n; ++i)  {
            socks[i] = sc.nextInt();
        }

        // make graphs
        for (int i = 0; i < m; ++i) {
            int e1 = sc.nextInt();
            int e2 = sc.nextInt();
            graphs.get(e1).add(e2);
            graphs.get(e2).add(e1);
        }
        pw.print(solution(graphs, socks));
        pw.close();
    }
}
