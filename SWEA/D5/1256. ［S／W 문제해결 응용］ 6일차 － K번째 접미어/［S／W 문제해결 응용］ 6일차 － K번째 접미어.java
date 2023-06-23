import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    static final String NONE = "NONE";

    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int tc = 1 ; tc <= T ; tc++) {
            int K = Integer.parseInt(br.readLine());

            String word = br.readLine();

            ArrayList<String> list = new ArrayList<>();

            for (int i = 0 ; i < word.length() ; i++)
                list.add(word.substring(i));

            Collections.sort(list);

            sb.append("#").append(tc).append(" ");

            if (K > list.size()) {
                sb.append(NONE).append("\n");
            } else {
                sb.append(list.get(K - 1)).append("\n");
            }
        }

        System.out.print(sb);
    }
}