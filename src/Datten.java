
import java.util.Scanner;

public class Datten {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        String tencay = "";
        while(N>0){
            N=N-1;
            long du=N%26;
            char k=(char)('a'+du);
            tencay=k+tencay;
            N=N/26;
        }
        System.out.println(tencay);

    }
}
