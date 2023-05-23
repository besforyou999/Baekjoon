import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int one = Integer.parseInt(st.nextToken());
		int two = Integer.parseInt(st.nextToken());
		int div = gcd(one, two);
		int mult = (one * two) / div;
		System.out.println(div);
		System.out.println(mult);
	}
	
	public static int gcd(int p, int q) {
		if(q == 0) return p;
		return gcd(q, p % q);
	}
}