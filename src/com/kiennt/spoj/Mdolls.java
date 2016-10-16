/*
"Dilworth" có một bộ sưu tập các con búp bê Nga.  Búp bê với chiều rộng w1
và chiều cao h1 sẽ nằm trong được con lật đật chiều rộng w2 và chiều cao h2
nếu w1 < w2 và h1 < h2.

Tính số lớp búp bê bao nhau ít nhất mà có thể tạo ra được từ các búp bê ban đầu.
Image and video hosting by TinyPic
Input
Dòng đầu là số test,  1 ≤ t ≤ 20. Mỗi test bắt đầu là số nguyên m, 1 ≤ m ≤ 20000,
số lượng búp bê ban đầu. Dòng tiếp theo là 2m số nguyên w1, h1,w2, h2,
... ,wm, hm, là chiều rộng và chiều cao của con búp bê thứ i, 1 ≤ wi, hi ≤ 10000.

SAMPLE INPUT
4
3
20 30 40 50 30 40
4
20 30 10 10 30 20 40 50
3
10 30 20 20 30 10
4
10 10 20 30 40 50 39 51
Output

Ghi số lớp búp bê bao nhau ít nhất có thể trên một dòng cho từng test.

SAMPLE OUTPUT
1
2
3
2
 */
package com.kiennt.spoj;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Mdolls {
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

    static class Doll {
        int w;
        int h;

        public Doll(int w, int h) {
            this.w = w;
            this.h = h;
        }

        public boolean canEat(Doll other) {
            return (this.w > other.w && this.h > other.h);
        }

        public String toString() {
            return "(" + Integer.toString(w) + ", " + Integer.toString(h) + ")";
        }
    }

    private static int findPosition(Doll[] a, int l, int h, Doll key) {
        if (h == -1 || !key.canEat(a[h])) {
            return -1;
        }

        while (l < h) {
            int mid = (l + h) / 2;
            if (!key.canEat(a[mid]) && key.canEat(a[mid + 1])) {
                return mid + 1;
            } else if (key.canEat(a[mid])) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    public static int solution(Doll[] a) {
        Arrays.sort(a, new Comparator<Doll>() {
            @Override
            public int compare(Doll o1, Doll o2) {
                if (o1.w > o2.w) {
                    return 1;
                } else if (o1.w == o2.w) {
                    if (o2.h > o1.h) {
                        return 1;
                    } else if (o2.h == o1.h) {
                        return 0;
                    } else {
                        return -1;
                    }
                } else {
                    return -1;
                }
            }
        });
        int size = 0;

        for (Doll item: a) {
            int pos = findPosition(a, 0, size - 1, item);
            if (pos == -1) {
                a[size] = item;
                size += 1;
            } else {
                a[pos] = item;
            }
        }

        return size;
    }

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
        int t = sc.nextInt();
        for (int i = 0; i < t; ++i) {
            int n = sc.nextInt();
            Doll[] a = new Doll[n];
            for (int j = 0; j < n; ++j) {
                a[j] = new Doll(sc.nextInt(), sc.nextInt());
            }
            pw.println(solution(a));
        }
        pw.close();
    }
}
