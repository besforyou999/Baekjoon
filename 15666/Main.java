package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static int src[];
	public static int rec[];
	public static LinkedHashSet<String> set = new LinkedHashSet<>();
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
		
		for (String str : set) {
			System.out.println(str);
		}
		
	}
	
	public static void dfs(int depth) {
		if (depth == M) {
			if (notDescend()) {
				set.add(buildString());
			}
			return;
		}
		
		for (int i = 0 ; i < N ; i++) {
			rec[depth] = src[i];
			dfs(depth + 1);
		}
		
	}
	
	public static String buildString( ) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0 ; i < M ; i++) {
			sb.append(rec[i]).append(" ");
		}
		return sb.toString();
	}
	
	public static boolean notDescend() {
		for (int i = 0 ; i < M - 1; i++) {
			if (rec[i] > rec[i + 1]) return false;
		}
		return true;
	}
	
}
