import java.util.Scanner;

public class Chiahet {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] a = new int[n + 1];
    int[] first = new int[k];
    int[] last = new int[k];
    for (int i = 0; i < k; i++) {
      first[i] = -1;
      last[i] = -1;
    }
    int sum = 0;
    first[0] = 0;
    last[0] = 0;
    for (int i = 1; i <= n; i++) {
      a[i] = sc.nextInt();
      sum = (sum + a[i]) % k;
      if (first[sum] == -1) {
        first[sum] = i;
      }
      last[sum] = i;
    }
    int maxLength =0;
    int p=1,q=1;
    for (int i = 0; i < k; i++) {
      if (first[i] != -1) {
        int length = last[i] - first[i];
        if (length > maxLength) {
          maxLength = length;
          p= first[i]+1;
          q= last[i];
        }
      }
    }
    System.out.println(p + " " + q);
  } 
   
}