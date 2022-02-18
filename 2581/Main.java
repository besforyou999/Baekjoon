import java.io.*;
import java.util.*;

public class Main {

	static int M, N;
	static boolean notPrimeNum[];

	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		M = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
			
		notPrimeNum = new boolean[N+1];
		notPrimeNum[0] = notPrimeNum[1] = true;

		for ( int i = 2 ; i <= N ; i++ ) {
			if (notPrimeNum[i] == false) {
				for (int j = i * i ; j <= N ; j += i ) 
					notPrimeNum[j] = true;
			}				
		}

		int sum = 0;
		int min = -1;

		for (int i = M ; i <= N ; i++) {
			if (notPrimeNum[i] == false) {
				sum += i;
				if (min == - 1) min = i;
			}
		}
	
		if (sum != 0 ) System.out.println(sum);
		System.out.print(min);		
	}
}
