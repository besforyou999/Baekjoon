import java.util.Scanner;

public class Main {
	public static void main(String [] args) {

		Scanner sc = new Scanner(System.in);
		
		int DIV = 10007;
		int n = sc.nextInt();

		int mat[][] = new int[n+1][10];
		int i, j ,k;

		for (i = 0 ; i <= 9 ; i++ ) mat[1][i] = 1;

		for ( i = 2 ; i <= n ; ++i) {
			for ( j = 0 ; j <= 9 ; ++j) {
				for ( k = j ; k <= 9 ; ++k) {
					mat[i][k] += mat[i-1][j];
					mat[i][k] %= DIV;
				}
			}
		}

		int sum = 0;

		for ( i = 0 ; i <= 9 ; ++i) sum += mat[n][i];

		System.out.print(sum % DIV);
	}
}

