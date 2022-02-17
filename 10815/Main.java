import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	static int N, M;

	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		HashSet<Integer> numberSet = new HashSet<>();

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0 ; i < N ; i++) {
			numberSet.add(Integer.parseInt(st.nextToken()));
		}		
		
		M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		for (int i = 0 ; i < M ; i++) {
			int check = Integer.parseInt(st.nextToken());
			if (numberSet.contains(check) == true) bw.write(1 + " ");
			else
				bw.write(0 + " ");
		}	
		
		bw.write("\n");
		bw.close();
	}
}

