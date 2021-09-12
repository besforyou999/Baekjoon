import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main (String [] args) {
		Scanner sc = new Scanner(System.in);

		int T, n;
		int [] arr = new int[12];

		arr[1] = 1;	
		arr[2] = 2;	
		arr[3] = 4;

		for (int i = 4; i <= 11; i++)
			arr[i] = arr[i-1] + arr[i-2] + arr[i-3];

		T = sc.nextInt();

		for (int i = 0; i < T; i++){

			n = sc.nextInt();
		    	
			System.out.println(arr[n]);	
		}	

		return;
	}
}
