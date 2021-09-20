import java.util.Scanner;

public class Main {
	public static void main(String [] args) {

		Scanner sc = new Scanner(System.in);

		int t, n;
		long [] arr = new long[68];
		arr[0] = arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;

		for (int i = 4 ; i < 68 ; i++ ) 
			arr[i] = arr[i-1] + arr[i-2] + arr[i-3] + arr[i-4];

		t = sc.nextInt();

		while (t-- > 0 ) {
			n = sc.nextInt();
			System.out.println(arr[n]);
		}
	}
}
