import java.util.Scanner;

public class Main {
	public static void main( String [] args ) {
		Scanner sc = new Scanner(System.in);
		String f = "factor";
		String m = "multiple";
		String n = "neither";
		int first = sc.nextInt();
		int second = sc.nextInt();
		while(first != 0 && second != 0 ) {
			int test = 0;
			if ( first < second && second % first == 0 ) test = 1;
			else if ( first > second && first % second == 0 ) test = 2;
			
			if (test == 0 ) {
				System.out.println(n);
			} else if ( test == 1 ) {
				System.out.println(f);
			} else if ( test == 2 ) {
				System.out.println(m);
			}
			first = sc.nextInt();
			second = sc.nextInt();
		}
	}
}
