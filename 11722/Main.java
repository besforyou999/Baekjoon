import java.util.Scanner;

public class Main {
	public static void main(String [] args) {

		Scanner sc = new Scanner(System.in);

		final int MAX = 1001;
		int n;
		int arr[] = new int[MAX];
		int dp[] = new int[MAX];

		n = sc.nextInt();

		for ( int i = 1 ; i <= n ; i++ )	
			arr[i] = sc.nextInt();

		int ans = -1;

		for ( int i = 1; i <= n ; i++ ) {
			dp[i] = 1;
			for ( int j = 1 ; j <= i ; j++ ) {
				if ( dp[i] < dp[j] + 1 && arr[i] < arr[j] ) 
					dp[i] = dp[j] + 1;
			}
			if ( ans < dp[i] ) 	ans = dp[i];
		}

		System.out.print(ans);
	}
}
