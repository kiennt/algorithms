/**
 http://vn.spoj.com/problems/LIS/

 (Giống bài LIQ) Cho một dãy gồm N số nguyên (1 ≤ N ≤ 30000). Hãy tìm dãy con tăng dài nhất trong dãy đó. In ra số lượng phần tử của dãy con. Các số trong phạm vi longint.

 Input
 Dòng đầu tiên gồm số nguyên N.
 Dòng thứ hai gồm N số mô tả dãy.
 Output
 Gồm một số nguyên duy nhất là đáp số của bài toán

 Example
 Input:
 5
 2 1 4 3 5

 Output:
 3
 */
package com.kiennt.spoj;

import java.io.*;
import java.util.StringTokenizer;

public class Lis {
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

    private static int findPosition(long[] a, int l, int h, long key) {
        if (h == -1 || a[h] < key) {
            return -1;
        }

        while (l < h) {
            int mid = (l + h) / 2;
            if (a[mid] < key && key <= a[mid + 1]) {
                return mid + 1;
            } else if (a[mid] >= key) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    public static int solution(long[] a) {
        int lcsSize = 0;
        for(long item: a) {
            int pos = findPosition(a, 0, lcsSize - 1, item);
            if (pos == -1) {
                a[lcsSize] = item;
                lcsSize += 1;
            } else {
                a[pos] = Math.min(a[pos], item);
            }
        }
        return lcsSize;
    }

    public static void main(String args[]) {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int N = sc.nextInt();
        long[] a = new long[N];
        for (int i = 0; i < N; ++i) {
            a[i] = sc.nextLong();
        }
        out.println(solution(a));
        out.close();
    }
}
