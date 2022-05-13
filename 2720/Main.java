import java.io.*;
import java.util.*;

public class Main {
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T ; i++) {
            int C = Integer.parseInt(br.readLine());

            Integer quarter = C / 25;
            C = C - 25 * quarter;

            Integer dime = C / 10;
            C = C - 10 * dime;

            Integer Nickel = C / 5;
            C = C - 5 * Nickel;

            Integer Penny = C / 1;

            bw.write(quarter + " " + dime + " " + Nickel + " " + Penny + "\n");
            bw.flush();
        }
    }
}

