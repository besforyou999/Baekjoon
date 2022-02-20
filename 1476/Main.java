import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int E, S, M;

		StringTokenizer st = new StringTokenizer(br.readLine());

		E = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int e,s,m,ans;
		e = s = m = ans = 1;

		while (true) {
			if (e == E && s == S && m == M ) break;
	
			ans += 1;
			e += 1;
			s += 1;
			m += 1;		
		
			if (e > 15 ) e = 1;
			if (s > 28 ) s = 1;
			if (m > 19 ) m = 1;

		}
		bw.write(ans);
		bw.flush();
		bw.close();
	}
}
