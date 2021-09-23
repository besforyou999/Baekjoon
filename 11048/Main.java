import java.util.Scanner;

public class Main {
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);

		int N, M;
		final int MAX = 1001;
		int mat[][] = new int[MAX][MAX];
		int dp[][] = new int[MAX][MAX];

		N = sc.nextInt();
		M = sc.nextInt();

		for ( int i = 1 ; i <= N ; i++ ) 
			for ( int j = 1 ; j <= M ; j++ ) 
				mat[i][j] = sc.nextInt();

		for ( int i = 1 ; i <= N ; i++ ) {
			for ( int j = 1 ; j <= M ; j++ ) {
				dp[i][j] = biggest(dp[i-1][j-1] ,dp[i-1][j] , dp[i][j-1]) + mat[i][j];
			}
		}

		System.out.print(dp[N][M]);
	
	}

	public static int biggest(int a, int b, int c) {
		int max = -1;

		if ( max < a ) max = a;
		if ( max < b ) max = b;
		if ( max < c ) max = c;

		return max;
	}
}	
