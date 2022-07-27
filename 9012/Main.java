import java.io.*;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            String line = br.readLine();
            bw.write(det(line) + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static String det(String line) {
        Character left = '(', right = ')';
        char [] arr = line.toCharArray();

        Stack<Character> stack = new Stack<>();

        for (Character ch : arr) {
            if (ch.equals(left)) stack.add(ch);
            else if (ch.equals(right)) {
                if (stack.isEmpty() == false) {
                    Character top = stack.peek();
                    if (top.equals(left) == false) stack.add(right);
                    else if (top.equals(left)) stack.pop();
                } else
                    stack.add(right);
            }
        }

        if (stack.isEmpty()) return "YES";
        return "NO";
    }
}
