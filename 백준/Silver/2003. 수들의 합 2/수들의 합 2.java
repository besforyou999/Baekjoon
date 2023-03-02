import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [] numbers = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0 ; i < N ; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		int [] Si = new int[N + 1];
		
		Si[0] = 0;
		
		for (int i = 1 ; i <= N ; i++) {
			Si[i] = numbers[i - 1] + Si[i-1];
		}
		
		int cnt = 0;
		
		for (int i = 0 ; i < N ; i++) {
			for (int j = i ; j <= N ; j++) {
				int diff =  Si[j] - Si[i];
				if (diff == M) cnt += 1;
			}
		}
		
		System.out.println(cnt);
	}
	
}