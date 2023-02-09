package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int DIFF = Integer.MAX_VALUE;
	static int N, M;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		if (N == 1) {
			System.out.println(0);
			System.exit(0);
		}
		
		arr = new int[N];
		
		for (int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int lp = 0;
		int rp = 0;
		
		while (lp < N && rp < N) {
			int diff = arr[rp] - arr[lp];
			
			if (diff < M) {
				rp++;
			} else {
				if (DIFF > diff) { 
					DIFF = diff;
				}
				lp++;
			}
		}
		
		System.out.println(DIFF);
	}
}