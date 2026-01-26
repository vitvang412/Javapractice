import java.util.Scanner;

public class VSGA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maxVal = 100001; 
        long[] count = new long[maxVal];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            count[x]++;
        }
        long[] point = new long[maxVal];
        for (int i = 1; i < maxVal; i++) {
            point[i] = (long) i * count[i];
        }
        long[] dp = new long[maxVal];
        dp[0] = 0;
        dp[1] = point[1];
        for (int i = 2; i < maxVal; i++) {
            dp[i] = Math.max(dp[i - 1], point[i] + dp[i - 2]);
        }
        
        System.out.println(dp[maxVal - 1]);
    }
}