/**
 http://vn.spoj.com/problems/QBDIVSEQ/

 QBDIVSEQ - Chia dãy
 Dãy số M phần tử B được gọi là dãy con của dãy số A gồm N phần tử nếu tồn tại một mã chuyển C gồm M phần tử thoả mãn B[i]=A[C[i]] với mọi I = 1…M và 1 ≤ C[1] < C[2] < ... < C[m] ≤ N.

 Một cách chia dãy A thành các dãy con "được chấp nhận" nếu các dãy con này là các dãy không giảm và mỗi phần tử của dãy A thuộc đúng một dãy con.

 Yêu cầu: Bạn hãy chia dãy con ban đầu thành ít dãy con nhất mà vẫn "được chấp nhận".

 Input
 Dòng đầu tiên ghi số N là số phần tử của dãy A. ( N ≤ 105 )

 N dòng tiếp theo ghi N số tự nhiên là các phần tử của dãy A. ( Ai ≤ 109 )

 Output
 Ghi một duy nhất là số lượng dãy con ít nhất thỏa mãn.

 Example
 Input:
 4
 1
 5
 4
 6

 Output:
 2
 */
package com.kiennt.spoj;

import java.io.*;
import java.util.StringTokenizer;

public class Qbdivseq {
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

    private static int findPosition(int[] a, int l, int h, int key) {
        if (h == -1 || a[h] > key) {
            return -1;
        }

        while (l < h) {
            int mid = (l + h) / 2;
            if (a[mid] > key  && key >= a[mid + 1]) {
                return mid + 1;
            } else if (a[mid] <= key) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    public static int solution(int[] a) {
        int size = 0;

        for (int item: a) {
            int pos = findPosition(a, 0, size - 1, item);
            if (pos == -1) {
                a[size] = item;
                size += 1;
            } else {
                a[pos] = Math.max(a[pos], item);
            }
        }
        return size;
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
