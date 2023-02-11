package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int []liq;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int [] liq = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0 ; i < N ; i++) {
			liq[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(liq);
		
		int lp = 0;
		int rp = liq.length - 1;
	
		int L = lp;
		int R = rp;
		
		int feat = liq[lp] + liq[rp];
		int DIFF = Math.abs(feat);
		
		while (true) {
			if (feat < 0) {
				lp += 1;
			} else if (feat > 0) {
				rp -= 1;
			} else if (feat == 0) {
				System.out.println(liq[lp] + " " + liq[rp]);
				System.exit(0);
			}
			
			if (lp >= rp) break;
			
			feat = liq[lp] + liq[rp];
			
			if (DIFF > Math.abs(feat)) {
				L = lp;
				R = rp;
				DIFF = Math.abs(feat);
			}
		}
		
		System.out.println(liq[L] + " " + liq[R]);
	}
	
}