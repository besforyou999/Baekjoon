import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger N = new BigInteger(br.readLine());

        BigInteger lp = new BigInteger("1");
        BigInteger rp = N;
        BigInteger mid;

        while (true) {
            mid = lp.add(rp);
            mid = mid.divide(new BigInteger("2"));
            int result = (mid.multiply(mid)).compareTo(N);
            if (result == 0) break;
            else if (result == 1) rp = mid.subtract(new BigInteger("1"));
            else lp = mid.add(new BigInteger("1"));
        }

        System.out.println(mid.toString());
    }
}