import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String []args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int MAX = 101;
		int N , K;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int W [] = new int[MAX];
		int V [] = new int[MAX];
		int DP [][] = new int[MAX][100001];

		for (int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}


		for (int i = 1 ; i <= N ; i++) {
			for (int j = 1 ; j <= K ; j++) {
				if (j >= W[i])
					DP[i][j] = Math.max(DP[i-1][j], DP[i-1][j-W[i]] + V[i]);
				else
					DP[i][j] = DP[i-1][j];
			}
		}
		System.out.print(DP[N][K]);
	}

}