import java.util.Scanner;

public class Main {
	public static void main(String [] args) {

		Scanner sc = new Scanner(System.in);

		int MOD = 10000;
		int MAX = 1000000001;
		int fn[] = new int[MAX];
		
		fn[0] = 0;
		fn[1] = 1;
		fn[2] = 1;	

		for ( int i = 2 ; i <= MAX ; i++ ) 
			fn[i] = (fn[i-1] + fn[i-2] ) % MOD;

		while ( true ) {	
			
			int n = sc.nextInt();

			if ( n == -1 ) break;
		
			System.out.println(fn[n]);

		}

		return ;
	}
}


		
