import java.util.Scanner;
import java.util.Arrays;

public class Concat {
    static final long[] P10 = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            long L = sc.nextLong();
            long R = sc.nextLong();
            int[] a = new int[N];
            for (int i = 0; i < N; i++) a[i] = sc.nextInt();
            Arrays.sort(a);
            int[][] pos = new int[9][2];
            for(int i=0; i<9; i++) { pos[i][0] = -1; pos[i][1] = -1; }

            for (int i = 0; i < N; i++) {
                int d = countDigits(a[i]);
                if (pos[d][0] == -1) pos[d][0] = i;
                pos[d][1] = i;
            }
            long result = solve(a, pos, R, N) - solve(a, pos, L - 1, N);
            System.out.println(result);
        }
    }
    static long solve(int[] a, int[][] pos, long K, int N) {
        if (K <= 0) return 0;
        long count = 0;
        for (int d = 1; d <= 8; d++) {
            if (pos[d][0] == -1) continue;
            int start = pos[d][0];
            int end = pos[d][1];
            int j = end;
            for (int i = 0; i < N; i++) {
                long prefix = (long) a[i] * P10[d];
                if (prefix > K) break; 

                while (j >= start && prefix + a[j] > K) {
                    j--;
                }
                
                if (j < start) break;
                count += (j - start + 1);
            }
        }
        return count;
    }
    static int countDigits(int n) {
        if (n < 10) return 1;
        if (n < 100) return 2;
        if (n < 1000) return 3;
        if (n < 10000) return 4;
        if (n < 100000) return 5;
        if (n < 1000000) return 6;
        if (n < 10000000) return 7;
        return 8;
    }
}