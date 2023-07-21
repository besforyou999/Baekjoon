import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Locale;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<>();

        char [] temp = br.readLine().toCharArray();

        for (int i = 0 ; i < temp.length ; i++) {

            char ch = temp[i];

            stack.add(ch);

            if (stack.size() >= 4) {
                checkPPAP(stack);
            }
        }

        if (stack.size() > 1) {
            System.out.println("NP");
        } else {
            Character result = stack.pop();
            if (result == 'P') {
                System.out.println("PPAP");
            } else {
                System.out.println("NP");
            }
        }

    }

    public static void checkPPAP(Stack<Character> stack) {

        ArrayDeque<Character> deque = new ArrayDeque<>();

        for (int i = 0 ; i < 4 ; i++) {
            deque.addFirst(stack.pop());
        }

        StringBuilder sb = new StringBuilder();

        for (Character ch : deque) {
            sb.append(ch);
        }

        if (sb.toString().equals("PPAP")) {
            stack.add('P');
        } else {
            stack.addAll(deque);
        }

    }
}