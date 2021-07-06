import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String [] args ) {
		Scanner sc = new Scanner(System.in);
		int first = sc.nextInt();
		int second = sc.nextInt();
		int a = Divider(first, second);
	}

	public static int Divider(int first, int second) {
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		ArrayList<Integer> arr2 = new ArrayList<Integer>();

		for (int i = 1 ; i <= first ; i++ ) {
			if (first % i == 0 ) {
				arr1.add(i);
			}
		}

		for (int j = 1; j <= second ; j++) {
			if (second % j == 0 ) {
				arr2.add(j);
			}
		}
		
		int last = arr1.size();
		int best = 0;
		for (int i = last -1 ; i >= 0 ; i-- ) {
			best = arr1.get(i);
			

		return 1;
	}
}
