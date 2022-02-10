import java.util.Scanner;

public class Main {
   
	static final int MOD = 1000000;
	public static void main(String [] args) {
       Scanner sc = new Scanner(System.in);
       long num = sc.nextLong();

       int pi = 1500000;

       num = num % pi;

       long [] fibo = new long[pi + 1];
       fibo[1] = 1;

       for (int i = 2 ; i <= pi ; i++)
           fibo[i] = (fibo[i-1] + fibo[i-2]) % MOD;

       System.out.println(fibo[(int)num]);
   }
}
