import java.util.Scanner;
import java.util.Arrays;

public class Main {
	
	public static void main(String []args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int [] arr = new int[N];

		for ( int i = 0; i < N ; i++ ) {
			arr[i] = sc.nextInt();
		}
	
		Arrays.sort(arr);

		int sum = 0;
		int sum2 = 0;
		for ( int Pi : arr ) {
			sum += Pi;
			sum2 += sum;
		}

		System.out.print(sum2);
	}
}	

