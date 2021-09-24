import java.util.Scanner;

public class Main {
	public static void main (String [] args) {

		Scanner sc = new Scanner(System.in);

		final int MAX = 1000001;
		int n , max = -1;
		int dp[] = new int[MAX];

		n = sc.nextInt();

		for ( int i = 1 ; i <= n ; i++ ) {
			int j = sc.nextInt();
			dp[j] = dp[j-1] + 1;
			if ( max < dp[j] ) max = dp[j];
		}

		System.out.print( n - max );
			
	}
}
						

