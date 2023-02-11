package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int X;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		X = Integer.parseInt(br.readLine());
		
		int result = 0;
		for (int i = 0 ; i < 7 ; i++) {
			if ( (X & (1 << i)) > 0) result++;
		}
		System.out.println(result);
	}
}