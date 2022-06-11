/*
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {

    }
}
*/
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Stack<Integer> stack;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        stack = new Stack<>();
        N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            Integer value = -1;
            if (st.hasMoreTokens() == true) value = Integer.parseInt(st.nextToken());

            switch(cmd) {
                case "push" : {
                    stack.push(value);
                    break;
                }
                case "pop" : {
                    if (stack.isEmpty()) {
                        bw.write(-1 + "\n");
                    } else
                        bw.write(stack.pop() + "\n");
                    break;
                }
                case "size" : {
                    bw.write(stack.size() + "\n");
                    break;
                }
                case "empty" : {
                    if (stack.isEmpty()) bw.write(1 + "\n");
                    else bw.write(0 + "\n");
                    break;
                }
                case "top" : {
                    if (stack.isEmpty())
                        bw.write("-1" + "\n");
                    else
                        bw.write(stack.peek() + "\n");
                    break;
                }
                default:
                    System.out.print("error");
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}
