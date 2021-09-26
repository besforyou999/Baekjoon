import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String [] args) {

		Scanner sc = new Scanner(System.in);

		// bag 3kg, 5kg
		int n;
		n = sc.nextInt();

		int [] threeKiloBags = new int[1700];
		int [] fiveKiloBags = new int[1700];
		int minTotalBags = 5000;

		for ( int i = 0 ; i <= n / 3 ; i++ ) {
			int temp = 0;
			threeKiloBags[i] = i;
			temp += i;
			if ( ( n - i*3) % 5 == 0 ) {
				int fiveKiloBagNum = ( n - i * 3 ) / 5;
				fiveKiloBags[i] = fiveKiloBagNum;
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
									

				
			
