import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Coord {
	int r, c;
	Coord(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Main3 {
	
	public static char mat[][] = new char[5][9];
	public static boolean used[] = new boolean[13];
	public static LinkedList<Coord> points = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0 ; i < 5 ; i++) {
			String line = br.readLine();
			for (int j = 0 ; j < 9 ; j++) {
				mat[i][j] = line.charAt(j);
				if (mat[i][j] == 'x') {
					points.add(new Coord(i, j));
				} else if (mat[i][j] != '.') {
					used[mat[i][j] - 65] = true;
				}
			}
		}
		
		dfs(0);
		
	}
	
	public static void dfs(int depth) {
		if (depth == points.size() ){
			if (checkIfValid()) {
				for (int i = 0 ; i < 5 ; i++) {
					for (int j = 0 ; j < 9 ; j++) {
						System.out.print(mat[i][j]);
					}
					System.out.println();
				}
				System.exit(0);
			} else {
				return;
			}
		}
		
		for (int i = 0 ; i < 12 ; i++) {
			if (!used[i]) {
				Coord cod = points.get(depth);
				mat[cod.r][cod.c] = (char)(i + 'A');
				used[i] = true;
				dfs(depth + 1);
				used[i] = false;
				mat[cod.r][cod.c] = 'x';
			}
		}
	}
	
	public static boolean checkIfValid() {
		int sum1 = (mat[0][4] - 'A' + 1) + (mat[1][3] - 'A' + 1) + (mat[2][2] - 'A' + 1) + (mat[3][1] - 'A' + 1);
		int sum2 = (mat[3][1] - 'A' + 1) + (mat[3][3] - 'A' + 1) + (mat[3][5] - 'A' + 1) + (mat[3][7] - 'A' + 1);
		int sum3 = (mat[3][7] - 'A' + 1) + (mat[2][6] - 'A' + 1) + (mat[1][5] - 'A' + 1) + (mat[0][4] - 'A' + 1);
		int sum4 = (mat[1][1] - 'A' + 1) + (mat[2][2] - 'A' + 1) + (mat[3][3] - 'A' + 1) + (mat[4][4] - 'A' + 1);
		int sum5 = (mat[4][4] - 'A' + 1) + (mat[3][5] - 'A' + 1) + (mat[2][6] - 'A' + 1) + (mat[1][7] - 'A' + 1);
		int sum6 = (mat[1][7] - 'A' + 1) + (mat[1][5] - 'A' + 1) + (mat[1][3] - 'A' + 1) + (mat[1][1] - 'A' + 1);
		if (sum1 == 26 && sum2 == 26 && sum3 == 26 && sum4 == 26 && sum5 == 26 && sum6 == 26) {
			return true;
		}
		return false;
	}
}
