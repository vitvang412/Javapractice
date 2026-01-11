import java.util.Scanner;

public class GiaXau {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext())
            return;
        String xau = sc.next();
        int n = xau.length();
        int[] a = new int[n + 1];
        for (int i = 0; i < n; i++) {
            a[i + 1] = xau.charAt(i) - 96;
        }
        long tongCuoi = 0;
        long tongBinhPhuong = 0;
        long MOD = 1000000007L;

        for (int j = 1; j <= n; j++) {
            long v = a[j];
            tongBinhPhuong = (tongBinhPhuong + (long) j * j) % MOD;

            long dongGop = (v * tongBinhPhuong) % MOD;
            dongGop = (dongGop * (n - j + 1)) % MOD;

            tongCuoi = (tongCuoi + dongGop) % MOD;
        }

        System.out.println(tongCuoi);
    }
}