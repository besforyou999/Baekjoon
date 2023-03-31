import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		M = Integer.parseInt(br.readLine());
		
		int S = 0;
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0 ; i < M ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int value = 0;
			String cmd = st.nextToken();
			
			switch(cmd) {
			case "add" :
				value = Integer.parseInt(st.nextToken());
				S |= (1 << (value - 1));
				break;
			case "remove":
				value = Integer.parseInt(st.nextToken());
				S = S & ~(1 << (value - 1));
				break;
			case "check":
				value = Integer.parseInt(st.nextToken());
				sb.append( (S & (1 << (value - 1))) != 0 ? "1\n" : "0\n");
				break;
			case "toggle":
				value = Integer.parseInt(st.nextToken());
				S ^= (1 << (value - 1));
				break;
			case "all":
				S |= (~0);
				break;
			case "empty":
				S &= 0;
				break;
			}
		}
		
		System.out.println(sb);
	}
}