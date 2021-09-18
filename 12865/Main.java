import java.util.Scanner;

public class Main {
	public static void main(String [] args) {

		Scanner sc = new Scanner(System.in);
		final int MAX = 101;
		int N, K;
		int w_arr[] = new int[MAX];
		int v_arr[] = new int[MAX];
		int dp[][] = new int[MAX][100001];

		N = sc.nextInt();
		K = sc.nextInt();

		for ( int i = 1 ; i <= N ; i++ ) {
			w_arr[i] = sc.nextInt();
			v_arr[i] = sc.nextInt();
		}

		for ( int i = 1 ; i <= N ; i++ ) {
			for ( int j = 1 ; j <= K ; j++ ) {
				if ( j >= w_arr[i] ) 
					dp[i][j] = Bigger( dp[i-1][j], dp[i-1][j-w_arr[i]] + v_arr[i] );
				else
					dp[i][j] = dp[i-1][j];		
			}
		}

		System.out.print(dp[N][K]);
	}

	public static int Bigger(int a, int b) {
		if ( a > b )
			return a;
		else
			return b;
	}
}
