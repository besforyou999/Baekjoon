import java.io.*;
import java.util.*;

public class Main {
	public static void main ( String [] args ) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0 ; i < T ; i++) {
			int N = Integer.parseInt(br.readLine());
			
			ArrayList<Pair> arr = new ArrayList<>(N);
			
			for (int j = 0 ; j < N ; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr.add(new Pair(x,y));
			}	

			Collections.sort(arr);

			int MAX = arr.get(0).y;
			int cnt = 0;

			for (int j = 0 ; j < N ; j++) {
				Pair p = arr.get(j);
				if (p.y <= MAX) {
					cnt += 1;
					MAX = p.y;
				}
			}

			bw.write(cnt +"\n");
			bw.flush();
		}
	}
}

class Pair implements Comparable<Pair> {
	public int x;
	public int y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Pair o) {
		if (this.x < o.x) return -1;
		else if (this.x == o.x) return 0;
		else return 1;
	}
}
