import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int C, MAX = -1;
	public static int src[][] = new int[11][11];
	public static boolean position[] = new boolean[11];
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		C = Integer.parseInt(br.readLine());
		
		while (C-- > 0) {
			
			for (int i = 0 ; i < 11 ; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0 ; j < 11 ; j++) {
					src[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			rec(0, 0);
			
			System.out.println(MAX);
			MAX = -1;
			Arrays.fill(position, false);
		}
		
	}
	
	public static void rec(int cost, int player) {
		if (player == 11) {
			MAX = Math.max(cost, MAX);
			return;
		}
		
		for (int i = 0 ; i < 11 ; i++) {
			if (src[player][i] != 0 && !position[i] ) {
				position[i] = true;
				rec(cost + src[player][i], player + 1);
				position[i] = false;
			}
		}
	}
}

// p p d p
// public protected default private