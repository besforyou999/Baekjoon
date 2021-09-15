import java.util.Scanner;

public class Main {

	public static int Bigger (int a, int b) {
		if ( a > b )
			return a;
		else
			return b;
	}

	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t, n;
		int mat[][] = new int[2][100001];
		int dp[][] = new int[2][100001];

		t = sc.nextInt();
		
		while ( t-- > 0 ) {	

			n = sc.nextInt();
		
			for (int i = 1; i <= n ; i++) {
				mat[0][i] = sc.nextInt();
			}

			for (int i = 1; i <= n ; i++) {
				mat[1][i] = sc.nextInt();
			}
		
			dp[0][0] = dp[1][0] = 0;
			dp[0][1] = mat[0][1];
			dp[1][1] = mat[1][1];
			
			for (int j = 2; j <= n ; j++) {
				dp[0][j] = Bigger(dp[1][j-1], dp[1][j-2]) + mat[0][j];
				dp[1][j] = Bigger(dp[0][j-1], dp[0][j-2]) + mat[1][j];
			}
					
			int ans = Bigger(dp[0][n], dp[1][n]);

			System.out.println(ans);
		}
	
	}
}
