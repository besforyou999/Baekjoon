import java.io.*;
import java.util.*;

public class Main {
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;

        while(true) {

            line = br.readLine();

            if (line.equals("."))
                break;

            bw.write(solve(line) + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static String solve(String str) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0 ; i < str.length() ; i++) {
            Character c = str.charAt(i);

            if (c.equals('(') || c.equals('[')) {
                stack.push(c);
            } else if (c.equals(')')) {
                if (stack.empty() || stack.peek().equals('(') == false) return "no";
                else
                    stack.pop();
            } else if (c.equals(']')) {
                if (stack.empty() || stack.peek().equals('[') == false) return "no";
                else
                    stack.pop();
            }
        }

        if (stack.isEmpty()) {
            return "yes";
        } else {
            return "no";
        }

    }
}


