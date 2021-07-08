import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        int N, K;
        N = sc.nextInt();
        K = sc.nextInt();

        int result = Fac(N) / ( Fac(K) * Fac(N - K) );
        System.out.print(result);
    }
    public static int Fac(int n) {
        if ( n<= 1 ) return 1;
        return Fac(n -1) * n;
    }
}
