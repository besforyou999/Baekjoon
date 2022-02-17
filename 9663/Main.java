import java.io.*;

public class Main {
	static int count = 0, n;
	static int mat[] = new int[15];

	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		n = Integer.parseInt(br.readLine());

		nqueen(0);

		System.out.print(count);
	}

	public static int promising(
	
	public static void nqueen(int cdx) {
		if (n == cdx) {
			count += 1;
			return;
		}

		for (int i = 0 ; i < n; i++) {
			mat[cdx] = i;
			if (promising(i) == 1) nqueen(cdx + 1);	
		}
	
	}

}
