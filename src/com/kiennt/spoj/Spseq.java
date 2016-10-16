/**
 http://vn.spoj.com/problems/SPSEQ/

 W. là 1 dãy các số nguyên dương. Nó có các đặc điểm sau:

 - Độ dài của dãy là 1 số lẻ: L = 2*N + 1

 - N + 1 số nguyên đầu tiên của dãy tạo thành 1 dãy tăng

 - N + 1 số nguyên cuối của dãy tạo thành 1 dãy giảm

 - Không có 2 số nguyên nào cạnh nhau trong dãy có giá trị bằng nhau

 Ví dụ: 1, 2, 3, 4, 5, 4, 3, 2, 1 là 1 dãy W. độ dài 9. Tuy nhiên, dãy 1, 2, 3, 4, 5, 4, 3, 2, 2 không là 1 dãy W.

 Yêu cầu: Trong các dãy con của dãy số cho trước, tìm dãy W. có độ dài dài nhất.

 Input
 Dòng 1: số nguyên dương N (N <= 100000), độ dài dãy số.

 Dòng 2: N số nguyên dương ai (ai <= 109).

 Output
 1 số nguyên dương duy nhất là độ dài dãy W. dài nhất.

 Example
 Input:
 10
 1 2 3 4 5 4 3 2 1 10

 Output:
 9

 Input:
 19
 1 2 3 2 1 2 3 4 3 2 1 5 4 1 2 3 2 2 1

 Output:
 9
 */
package com.kiennt.spoj;

import java.io.*;
import java.util.StringTokenizer;

public class Spseq {

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

    public static int[] buildLcs(int[] a, int[] m, int start, int end, int diff) {
        int lcs[] = new int[a.length];
        int maxSize = 0;
        for (int i = start; i != end; i = i + diff) {
            int pos = findPosition(m, 0, maxSize - 1, a[i]);
            if (pos == -1) {
                m[maxSize] = a[i];
                maxSize += 1;
                lcs[i] = maxSize;
            } else {
                m[pos] = Math.min(m[pos], a[i]);
                lcs[i] = pos + 1;
            }
        }

        return lcs;
    }

    public static int[] buildLcsIndexIncrease(int[] a, int[] m) {
        return buildLcs(a, m, 0, a.length, 1);
    }

    public static int[] buildLcsIndexDecrease(int[] a, int[] m) {
        return buildLcs(a, m, a.length - 1, -1, -1);
    }

    public static int solution(int[] a) {
        int m[] = new int[a.length];
        int maxSize = 0;
        int[] lcs1 = buildLcsIndexIncrease(a, m);
        int[] lcs2 = buildLcsIndexDecrease(a, m);
        for (int i = 0; i < a.length; ++i) {
            int lcsAt = Math.min(lcs1[i], lcs2[i]);
            maxSize = Math.max(maxSize, lcsAt);
        }
        return maxSize * 2 - 1;
    }

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = sc.nextInt();
        }
        out.println(solution(a));
        out.close();
    }
}
