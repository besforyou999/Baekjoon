import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int mat[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		mat = new int[9][9];
		int cnt = 0;
		for (int i = 0 ; i < 9 ; i++) {
			String line = br.readLine();
			for (int j = 0 ; j < 9 ; j++) {
				int val = line.charAt(j) - '0';
				mat[i][j] = val;
				if (val > 0) cnt++;
			}
		}
		
		rec(cnt, 0, 0);
	}
	
	public static void rec(int cnt, int r, int c) {
		if (cnt == 81) {
			printMat();
			System.exit(0);
		}
		
		// 다음 좌표 탐색
		while (mat[r][c] > 0) {
			c++;
			if (c == 9) {
				c = 0;
				r++;
			}
		}
		
		for (int i = 1 ; i <= 9 ; i++) {
			if (valid(r, c, i)) {
				mat[r][c] = i;
				rec(cnt + 1, r, c);
				mat[r][c] = 0;
			}
		}
	}
	
	public static void printMat() {
		for (int i = 0 ; i < 9 ; i++) {
			for (int j = 0 ; j < 9 ; j++) 
				System.out.print(mat[i][j]);
			System.out.println();
		}
	}
	
	
	public static boolean valid(int r, int c, int number) {
		
		for (int i = 0 ; i < 9; i++) {
			if (mat[r][i] == number || mat[i][c] == number) return false;
		}
		
		int row = (r / 3) * 3;
		int col = (c / 3) * 3;
		
		for (int i = 0 ; i < 3 ; i++) {
			for (int j = 0 ; j < 3 ; j++) {
				if (mat[row + i][col + j] == number) return false;
			}
		}
		
		return true;
	}
	
}