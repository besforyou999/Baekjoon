import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static int src[];
	public static int rec[];
	public static StringBuilder sb = new StringBuilder();
	public static void main (String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		src = new int[N];
		rec = new int[M];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0 ; i < N ; i++) {
			src[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(src);
		dfs(0);
		System.out.println(sb);
	}
	
	public static void dfs(int depth) {
		if (M == depth) {
			for (int a : rec) {
				sb.append(a).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0 ; i < N ; i++) {
			rec[depth] = src[i];
			dfs(depth + 1);
		}
	}
}
