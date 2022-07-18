import java.io.*;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0 ; i < input.length() ; i++) {
            Character ch = input.charAt(i);
            if (map.containsKey(ch) == false)
                map.put(ch, i);
        }
        char key = 'a';
        for (int i = 0 ; i < 26 ; i++) {
            if (map.containsKey(key) == false) {
                bw.write(-1 + " ");
            } else {
                bw.write(map.get(key) + " ");
            }
            key += 1;
        }
        bw.write("\n");
        bw.close();
    }
}
