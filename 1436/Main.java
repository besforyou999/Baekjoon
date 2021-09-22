import java.util.Scanner;

public class Main {
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int count = 0;
		int start = 666;

		while ( count < n ) {

			String str = Integer.toString(start);

			if ( str.find("666") == true ) {
				count += 1;
			}

			start += 1;
		}

		System.out.print(start - 1);
	}
}
