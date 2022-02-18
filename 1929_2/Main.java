import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static boolean notPrimeNum[];

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		notPrimeNum = new boolean[N+1];
		notPrimeNum[0] = notPrimeNum[1] = true;

		for (int i = 2 ; i * i <= N ; i++) {
			if (notPrimeNum[i] == false) 
				for (int j = i * i ; j <= N ; j += i ) notPrimeNum[j] = true;
		}

		for (int i = M ; i <= N ; i++) {
			if (notPrimeNum[i] == false) bw.write(i + "\n");
		}
		
		bw.flush();
		bw.close();
    }
}

