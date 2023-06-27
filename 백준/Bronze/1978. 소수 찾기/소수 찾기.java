import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int isPrime[];
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		isPrime = new int[1001];
		isPrime[0] = 1;
		isPrime[1] = 1;
		
		for (int i = 2 ; i < 1001 ; i++) {
			if (isPrime[i] == 0) {
				for (int j = i * i ; j < 1001 ; j += i) {
					isPrime[j] = 1;
				}
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = 0;
		for (int i = 0 ; i < N ; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (isPrime[num] == 0) cnt+= 1;
		}
		
		System.out.println(cnt);
	}
	
}