import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	static int N, K;
	public static void main(String [] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = sc.nextInt();
		K = sc.nextInt();

		ArrayList<Pair> arr = new ArrayList<>(N);	
		ArrayList<Integer> ans = new ArrayList<>();

		for (int i = 0 ; i < N ; i++) {
			arr.add(new Pair(i+1, false));
		}
		int idx = 0;
		int count = 0;
		int people_num = N;	
		while (people_num > 0 ) {
			Pair pair = arr.get(idx);
			if (pair.removed == false) count += 1;

			if (count == K ) {
				arr.get(idx).removed = true;		
				people_num -= 1;
				ans.add(pair.number);
				count = 0;
			}			

			idx += 1;	
			if (idx == N) idx = 0;
		}
		
		bw.write("<");
		
		for (int i = 0 ; i < N - 1 ; i++) bw.write(ans.get(i) + ", ");

		bw.write(ans.get(N-1) + ">");
		bw.flush();
		bw.close();
	}	
}

class Pair {
	public int number;
	public boolean removed;

	Pair(int number, boolean removed) {
		this.number = number;
		this.removed = removed;
	}
}
					
