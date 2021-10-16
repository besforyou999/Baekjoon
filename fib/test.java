import java.util.Scanner;

public class test {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();

		int f = fib(a);

		System.out.println(f);
	}

	public static int fib(int n ) {

		if ( n == 1 ) return 1;
		if ( n == 0 ) return 0;

		return fib(n-2) + fib(n-1);

	}
}
