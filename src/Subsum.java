import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Subsum {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                    return null;
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader(System.in);
        
        String inputN = fr.next();
        if (inputN == null) return;
        int N = Integer.parseInt(inputN);
        int S = fr.nextInt();
        
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = fr.nextInt();
        }
        int left = 0;
        long sum = 0;
        int minvalue = Integer.MAX_VALUE;
        
        for (int right = 0; right < N; right++) {
            sum += arr[right];
            while (sum > S) {
                int length = right - left + 1;
                if (length < minvalue) {
                    minvalue = length;
                }
                sum -= arr[left];
                left++;
            }
        }
        
        if (minvalue == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(minvalue);
        }
    }
}