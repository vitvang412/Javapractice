
import java.util.Scanner;

public class METRO_WA {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] c = new long[n + 1];
        for (int i = 1; i <= n; i++) c[i] = sc.nextLong();

        int[] l = new int[n + 1];
        int[] r = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            l[i] = sc.nextInt();
            r[i] = sc.nextInt();
        }

        long[] diff_f = new long[n + 2];
        long[] diff_S = new long[n + 2];

        diff_f[1] = 1;
        diff_f[2] = -1; 

        long curr_f = 0;
        long curr_S = 0;

        for (int i = 1; i <= n; i++) {
            curr_f = (curr_f + diff_f[i]) % MOD;
            curr_S = (curr_S + diff_S[i]) % MOD;

            if (i == n) {
                System.out.println(curr_S);
                return;
            }

            int L = i + l[i];
            int R = i + r[i]; 

            if (L > n) continue;
            if (R > n) R = n;

            long W = (curr_S + c[i]) % MOD; 

            diff_f[L] = (diff_f[L] + curr_f) % MOD;
            if (R + 1 <= n) diff_f[R + 1] = (diff_f[R + 1] - curr_f) % MOD; 

            diff_S[L] = (diff_S[L] + W) % MOD;
            if (R + 1 <= n) diff_S[R + 1] = (diff_S[R + 1] - W) % MOD; 
        }
    }
}