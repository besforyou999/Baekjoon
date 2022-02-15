import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String [] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		String line = br.readLine();

		String arr[] = line.split(" ");

		String A = arr[0];
		String B = arr[1];

		int a_len = A.length();
		int b_len = B.length();
		int min = 100;
		for (int i = 0 ; i <= b_len - a_len ; i++) {
			String splitB = B.substring(i, i + a_len);
			int diff = (compareStr(A, splitB));
			if (min > diff ) min = diff;
		}
		System.out.print(min);
	}

	public static int compareStr(String a, String b) {
		int count = 0;
		for (int i = 0 ; i < a.length() ; i++) {
			if (a.charAt(i) != b.charAt(i)) count += 1;
		}
		return count;	
	}
}
