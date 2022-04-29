import java.util.Scanner;
import java.io.*;

public class Main {
	public static void main (String [] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		long S = Long.parseLong(sc.next());

		long cnt = 1;

		while ( cnt <= S ) {
			S -= cnt;
			cnt += 1;
		}	
		System.out.print(cnt - 1);
	}
}
