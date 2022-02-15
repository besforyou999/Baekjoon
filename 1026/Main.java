import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.Arrays;

public class Main {
	public static void main(String [] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Integer A[] = new Integer[N];
		Integer B[] = new Integer[N];

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());

		for (int i = 0 ; i < N ; i++) {
			A[i] = Integer.parseInt(st1.nextToken());
			B[i] = Integer.parseInt(st2.nextToken());
		}
	
		Arrays.sort(A);
		Arrays.sort(B, Collections.reverseOrder());	

		int ans = 0;

		for (int i = 0 ; i < N ; i++) ans += A[i] * B[i];	

		System.out.print(ans);
	}
}
