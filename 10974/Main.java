package boj;

import java.io.*;

public class Main {
	static int N;
	static int[] src, tgt;
	static boolean[] select;
	
	public static StringBuilder sb = new StringBuilder();
	public static void main (String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		tgt = new int[N];
		src = new int[N];
		select = new boolean[N];
		
		for (int i = 0 ; i < N ; i++) {
			src[i] = i;
		}
		
		dfs(0);
		System.out.println(sb);
	}
	
	public static void dfs(int depth) {
		if (depth == N) {
			for (int i = 0 ; i < N ; i++) {
				sb.append((tgt[i] + 1)).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0 ; i < N ; i++) {
			if (!select[i]) {
				select[i] = true;
				tgt[depth] = src[i];
				dfs(depth + 1);
				select[i] = false;
			}
		}
	}
	
	
}
