package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
	public static int k;
	public static String src[];
	public static int arr[];
	public static int rec[];
	public static boolean visit[];
	
	public static void main (String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		src = new String[k];
		rec = new int[k + 1];
		visit = new boolean[10];
		arr = new int[10];
		for (int i = 0 ; i < 10 ; i++) {
			arr[i] = i;
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0 ; i < k ; i++) {
			src[i] = st.nextToken();
		}
		
		dfs(0);
	}
	
	public static void dfs(int depth) {
		if (depth == k + 1) {
			for (int a : rec) {
				System.out.print(a + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0 ; i < 10 ; i++) {
			if (!visit[i]) {
				visit[i] = true;
				rec[depth] = i;
				dfs(depth + 1);
				visit[i] = false;
			}
		}
	}
	
	
	public static
}
