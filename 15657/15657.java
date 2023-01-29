import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static int numbers[];
	public static int arr[];
	public static boolean visit[];
	public static StringBuilder sb = new StringBuilder();
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		arr = new int[M];
		visit = new boolean[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0 ; i < N ; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numbers);
		
		dfs(0);
		
		System.out.println(sb);
	}
	
	public static void dfs(int depth) {
		if (depth == M) {
			for (int i = 0 ; i < M - 1 ; i++) {
				if (arr[i] > arr[i+1]) return;
			}
			
			for (int n : arr) 
				sb.append(n).append(" ");
			
			sb.append("\n");
			return;
		}
		
		for (int i = 0 ; i < N ; i++) {
			arr[depth] = numbers[i];
			dfs(depth + 1);
		}
	}
	
}