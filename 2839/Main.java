import java.util.Scanner;

public class Main {
	public static void main(String [] args) {

		Scanner sc = new Scanner(System.in);

		int n;
		n = sc.nextInt();
		
		int minTotalBags = 5000;

		for ( int i = 0 ; i <= n / 3 ; i++ ) {
			int temp = 0;
			temp += i;
			if ( ( n - i*3) % 5 == 0 ) {
				int fiveKiloBagNum = ( n - i * 3 ) / 5;
				temp += fiveKiloBagNum;	
				if ( minTotalBags > temp ) 	minTotalBags = temp;
			}
		}	
		if ( minTotalBags == 5000 ) { 
			System.out.print(-1);		
			return ;
		}
		System.out.print(minTotalBags);
	}
}	
									

				
			
