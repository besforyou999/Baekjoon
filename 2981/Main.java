import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int [] arr = new int[N];

		for (int i = 0; i < N ; i++ ) 
			arr[i] = sc.nextInt();
	
		Arrays.sort(arr);

		int smallest = arr[0];

		ArrayList<Integer> array_of_M = new ArrayList<Integer>();

		for (int i = 2 ; i < smallest ; i++ ) {
			int same = 1;
			int divResult = arr[0] % i;
			for (int j = 1 ; j < N ; j++ ) {
				 if ( divResult != arr[j] % i ) {
					 same = 0;
					 break;
				 }
			}

			if ( same == 1 ) 
				array_of_M.add(i);			
		}

		for (int i = 0; i < array_of_M.size() ; i++ ) 
			System.out.println(array_of_M.get(i));				
	}
}
