import java.util.Scanner;

public class Main {
	public static void main(String [] args) {

		int [] arr = new int[1001];
		int [] dp = new int[1001];

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for ( int i = 1 ; i <= n ; i++ ) 
			arr[i] = sc.nextInt();

		for ( int i = 1 ; i <= n ; i++ ) {
			for (int j = 1 ; j <= i ; j++ ) {
				dp[i] = bigger(dp[i] , dp[i-j] + arr[j] );
			}
		}	

		System.out.print(dp[n]);

	}

	public static int bigger(int a, int b) {
		if ( a > b ) 
			return a;
		else
			return b;
	}
}
