import java.util.Arrays;
public class concat {
    static long[] P10 = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
    public static void main(String[] args) throws Exception {
        int T = readInt(); 
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = readInt();
            long L = readLong();
            long R = readLong();
            int[] a = new int[N];
            for (int i = 0; i < N; i++) a[i] = readInt();
            Arrays.sort(a);
            int[] start = new int[9];
            int[] end = new int[9];
            Arrays.fill(start, -1);

            for (int i = 0; i < N; i++) {
                int d = getLen(a[i]);
                if (start[d] == -1) start[d] = i;
                end[d] = i;
            }

            long ans = solve(a, start, end, R, N) - solve(a, start, end, L - 1, N);
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
    static long solve(int[] a, int[] start, int[] end, long K, int N) {
        if (K <= 0) return 0;
        long total = 0;
        for (int d = 1; d <= 8; d++) {
            if (start[d] == -1) continue;
            int j = end[d];
            int s = start[d];
            for (int i = 0; i < N; i++) {
                long valA = (long) a[i] * P10[d];
                if (valA > K) break; 
                while (j >= s && valA + a[j] > K) {
                    j--;
                }
                
                if (j < s) break; 
                total += (j - s + 1);
            }
        }
        return total;
    }
    static int getLen(int n) {
        if (n < 10) return 1;
        if (n < 100) return 2;
        if (n < 1000) return 3;
        if (n < 10000) return 4;
        if (n < 100000) return 5;
        if (n < 1000000) return 6;
        if (n < 10000000) return 7;
        return 8;
    }
    static int readInt() throws Exception {
        int c = System.in.read();
        while (c <= 32) c = System.in.read();
        int res = 0;
        while (c > 32) {
            res = res * 10 + (c - '0');
            c = System.in.read();
        }
        return res;
    }
    static long readLong() throws Exception {
        int c = System.in.read();
        while (c <= 32) c = System.in.read();
        long res = 0;
        while (c > 32) {
            res = res * 10 + (c - '0');
            c = System.in.read();
        }
        return res;
    }
}