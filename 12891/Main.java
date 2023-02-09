package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int S, P, ans = 0;
	static String DNA;
	static char[] dna_arr;
	static int used[] = new int[4]; // 'A', 'C', 'G', 'T'
	static int min[] = new int[4];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		DNA = br.readLine();
		dna_arr = DNA.toCharArray();
		st = new StringTokenizer(br.readLine());
		min[0] = Integer.parseInt(st.nextToken());
		min[1] = Integer.parseInt(st.nextToken());
		min[2] = Integer.parseInt(st.nextToken());
		min[3] = Integer.parseInt(st.nextToken());
		
		int lp = 0;
		int rp = P - 1;
		
		for (int i = 0 ; i < P ; i++) {
			increase(dna_arr[i]);
		}
		
		if (valid()) ans += 1;
		
		
		while (rp < S) {
			decrease(dna_arr[lp++]);
			
			rp += 1;
			if (rp >= S) break;
			
			increase(dna_arr[rp]);
			
			if (valid()) ans += 1;
		}
		
		System.out.println(ans);
		
	}
	
	static void decrease(char ch) {
		if (ch == 'A') {
			used[0] -= 1;
		} else if (ch == 'C') {
			used[1] -= 1;
		} else if (ch == 'G') {
			used[2] -= 1;
		} else 
			used[3] -= 1;
	}
	
	static void increase(char ch) {
		if (ch == 'A') {
			used[0] += 1;
		} else if (ch == 'C') {
			used[1] += 1;
		} else if (ch == 'G') {
			used[2] += 1;
		} else 
			used[3] += 1;
	}
	
	public static boolean valid() {
		for (int i = 0 ; i < 4 ; i++) {
			if (used[i] < min[i]) return false;
		}
		return true;
	}
	
}