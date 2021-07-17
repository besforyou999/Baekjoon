import java.util.Scanner;
import java.util.Vector;

public class Main {
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);

		String arr = new String();

		arr = sc.nextLine();
	
		String [] sub = arr.split("-");

		int sum = Integer.MAX_VALUE;

		for ( int i = 0 ; i < sub.length ; i++ ) {

			int temp = 0;

			String [] add = sub[i].split("\\+");

			for (int j = 0; j < add.length ; j++ ) {
				temp += Integer.parseInt(add[j]);
			}

			if ( sum == Integer.MAX_VALUE ) {
				sum = temp;
			} else
				sum -= temp;
		}
		System.out.print(sum);
	}
}
