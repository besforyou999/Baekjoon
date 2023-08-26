import java.io.*;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        String temp = "";
        while(st.hasMoreTokens()) {
            temp = st.nextToken();
            count += 1;
        }
        System.out.print(count);
    }
}