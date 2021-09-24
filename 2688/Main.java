import java.util.Scanner;

public class Main {
	public static void main(String [] args) {

		Scanner sc = new Scanner(System.in);

		int n, T;
		T = sc.nextInt();
		
		while ( T-- > 0 ) {
			n = sc.nextInt();
			System.out.println(solve(n));
		}

		return ;
	}

	public static long solve( int n ) {

		long mat[][] = new long[65][10];

		for ( int i = 0 ; i <= 9 ; i++ )
			mat[1][i] = i + 1;

		for ( int i = 2 ; i <= n ; i++ ) {
			mat[i][0] = 1;
			for ( int j = 1 ; j <= 9 ; j++ ) {
				mat[i][j] = mat[i-1][j] + mat[i][j-1];
			}
		}
		return mat[n][9];		
	}
}
