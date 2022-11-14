import java.io.*;
import java.util.*;

public class Main
{
	public static int N;
	public static int Ai[];
	public static int symbols[] = new int[4];	// + - x %
	public static int max = -1100000000;
	public static int min = 1100000000;
	
	public static void main(String [] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Ai = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0 ; i < N ; i++) {
			Ai[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0 ; i < 4 ; i++) {
			symbols[i] = Integer.parseInt(st.nextToken());
		}
		
		calc(Ai[0], 1);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void calc(int total, int depth) {
		if (depth == N) {
			if (max < total) max = total;
			if (min > total) min = total;
			return;
		}
		
		for (int i = 0 ; i < 4 ; i++) {
			if (symbols[i] > 0) {
				symbols[i]--;
				switch(i) {
					case 0: calc(total + Ai[depth], depth + 1); break;
					case 1: calc(total - Ai[depth], depth + 1); break;
					case 2: calc(total * Ai[depth], depth + 1); break;
					case 3: calc(total / Ai[depth], depth + 1); break;
				}
				symbols[i]++;
			}
		}
	}
	
	
}