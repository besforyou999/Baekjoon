import java.io.*;
import java.util.*;

class Solution
{
	public static int N, count = 0;
	public static int board[] = new int[15];
	public static void main(String [] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nqueen(0);
		System.out.print(count);
	}
	
	public static int promising(int cdx) {
		for (int i = 0 ; i < cdx ; i++) {
			if (board[cdx] == board[i] || cdx - i == Math.abs(board[cdx] - board[i])) {
				return 0;
			}
		}
		return 1;
	}
	
	
	public static void nqueen(int cdx) {
		if (cdx == N) {
			count += 1;
			return;
		}
		
		for (int i = 0 ; i < N ; i++) {
			board[cdx] = i;
			if (promising(cdx) == 1) {
				nqueen(cdx + 1);
			}			
		}
	}
}