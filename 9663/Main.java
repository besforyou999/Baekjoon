import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int count = 0, n;
	static int board[] = new int[15];

	public static void main (String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		Main main = new Main();
		main.nqueen(0);		

		System.out.print(count);
	}

	private int promising(int cdx) {
		for (int i = 0 ; i < cdx ; i++) {
			if (board[cdx] == board[i] || cdx - i == Math.abs(board[cdx] - board[i])) return 0;
		}	
		return 1;
	}

	private void nqueen(int cdx) {

		if (cdx == n) {
			count++;
			return;
		}

		for (int i = 0 ; i < n ; i++) {
			board[cdx] = i;
			if (promising(cdx)==1) nqueen(cdx + 1);
		}
	}
}
