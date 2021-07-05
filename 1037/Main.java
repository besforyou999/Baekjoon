import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main( String [] args ) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		ArrayList arr = new ArrayList<Integer>();

		for (int i = 0 ; i < N ; i++ ) {
			int temp = sc.nextInt();
			arr.add(temp);
		}

		Collections.sort(arr);

		long ans = (long)arr.get(0) * (long)arr.get(N-1);

		System.out.print(ans);
	}
}
		
