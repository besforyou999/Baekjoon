import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int DIFF = Integer.MAX_VALUE;
	static int S[];
	static int B[];
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		S = new int[N];
		B = new int[N];
		
		for (int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		powerSetDupPer(0, new boolean[N]);
		System.out.println(DIFF);
	}
	
	static void powerSetDupPer(int nthCheck, boolean[] checked) {
    	if (nthCheck == checked.length) {
    		int Sour = 1;
    		int Bitter = 0;
    		int cnt_checked = 0;
    		for (int i = 0 ; i < checked.length ; i++) {
    			if (checked[i]) {
    				cnt_checked += 1;
    				Sour *= S[i];
    				Bitter += B[i];
    			}
    		}
    		if (cnt_checked == 0) return;
    		
    		int difference = Math.abs(Sour - Bitter);
    		if (DIFF > difference)
    			DIFF = difference;
    		
    		return;
    	}
    	
    	checked[nthCheck] = true;
    	powerSetDupPer(nthCheck + 1, checked);
    	checked[nthCheck] = false;
    	powerSetDupPer(nthCheck + 1, checked);
    }
	
}
