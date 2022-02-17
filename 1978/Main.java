import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int ans = 0;

		for (int i = 0 ; i < N ; i++) {
			int num = Integer.parseInt(st.nextToken());
			ans += isPrime(num);
		}	
		
		System.out.print(ans);
	}

	public static int isPrime(int num) {
	
		if (num == 1 ) return 0;

		for (int i = 2 ; i <= Math.sqrt(num) ; i++) {
			if (num % i == 0 ) return 0;
		}
		return 1;
	}
}
