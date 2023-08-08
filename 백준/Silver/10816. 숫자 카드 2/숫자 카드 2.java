import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> numCards = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            int number = Integer.parseInt(st.nextToken());
            if (!numCards.containsKey(number)) {
                numCards.put(number, 1);
            } else {
                int cnt = numCards.get(number);
                numCards.put(number, cnt + 1);
            }
        }

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            int find = Integer.parseInt(st.nextToken());
            if (numCards.containsKey(find)) {
                sb.append(numCards.get(find)).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.print(sb);
    }
}