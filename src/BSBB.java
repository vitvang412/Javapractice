import java.util.Scanner;
public class BSBB{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       int N =sc.nextInt();
       int count=0;
         for(int i=1;i<N;i++){
           int B=(N-1)/i;
           count=count+B;
          }
           System.out.println(count);
         }
    }