import java.util.Scanner;

public class Main {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int under = sc.nextInt();

		for (int i = 1 ; i < N ; i++ ) {

			int upper = sc.nextInt();

			int maxDiv = 0;
			for (int j = 1 ; j <= under && j <= upper ; j++ ) {
				if ( under % j == 0 && upper % j == 0 ) maxDiv = j;
			}

			System.out.println(under/maxDiv + "/" + upper/maxDiv);
		}	

	}
}
