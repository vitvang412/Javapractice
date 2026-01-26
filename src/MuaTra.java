import java.util.Arrays;
import java.util.Scanner;

public class MuaTra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int q = sc.nextInt();
        
        long[] c = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            c[i] = sc.nextLong();
        }
        Arrays.sort(c, 1, n + 1);
        long[] s = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + c[i];
        }
        StringBuilder ketQua = new StringBuilder();
        for (int i = 0; i < q; i++) {
            long k = sc.nextLong();
            int m = sc.nextInt();
            int p = 0;
            int lowP = 1, highP = n;
            while (lowP <= highP) {
                int mid = (lowP + highP) / 2;
                if (c[mid] < k) {
                    p = mid;
                    lowP = mid + 1;
                } else {
                    highP = mid - 1;
                }
            }
            int x = 0;
            int l = Math.max(0, m - (n - p)); 
            int r = Math.min(m, p);           
            
            while (l <= r) {
                int midX = (l + r) / 2;
                int midY = m - midX;
                long giaTriTrai = (midX < p) ? c[midX + 1] : Long.MAX_VALUE;
                long giaTriPhai = (midY > 0) ? (2 * k - c[n - midY + 1]) : Long.MAX_VALUE;
                if (giaTriTrai < giaTriPhai) {
                    x = midX + 1;
                    l = midX + 1;
                } else {
                    x = midX;
                    r = midX - 1;
                }
            }
            int finalX = Math.min(x, m);
            int finalY = m - finalX;
            long tongL_F = s[finalX]; 
            if (finalY > 0) {
                long tongGiaThuc = s[n] - s[n - finalY];
                tongL_F += (2 * k * finalY - tongGiaThuc); 
            }
            ketQua.append(tongL_F).append("\n");
        }
        System.out.print(ketQua.toString());
    }
}