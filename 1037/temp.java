import java.util.Scanner;
import java.util.Vector;

public class Main {
	public static void main( String [] args ) {
		Scanner sc = new Scanner(System.in);
		Vector<Integer> v = new Vector<Integer>();
		int biggest = -1;
		int count = sc.nextInt();
		int temp = 0;
		for (int i = 0; i < count ; i++ ) {
			temp = sc.nextInt();
			if ( temp > biggest ) biggest = temp;
			v.add(temp);
		}
		int temp2=0;
		int N = biggest + 1;
		while (true) {
			int check = 1;
			for (int i = 0; i < count ; i++ ) {
				temp2 = v.elementAt(i);
				int div = N % temp2;
				if ( div != 0 ) {
					check = 0;
					break;
				}
			}
			if ( check == 1 ) break;
			N += 1;
		}	
		System.out.print(N);
	}
}
		
