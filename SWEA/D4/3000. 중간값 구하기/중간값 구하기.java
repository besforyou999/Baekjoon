import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    static StringTokenizer st;

    static final long DIV = 20171109;

    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int tc = 1 ; tc <= T ; tc++) {

            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            maxHeap.add(A);

            long sum = 0;

            for (int n = 0 ; n < N ; n++) {
                st = new StringTokenizer(br.readLine());

                while (st.hasMoreTokens()) {
                    int X = Integer.parseInt(st.nextToken());
                    // 조건 1. maxheap의 크기는 minheap크기보다 같거나, 1개 더 많아야 함
                    if (maxHeap.size() == minHeap.size()) {
                        maxHeap.add(X);
                    } else {
                        minHeap.add(X);
                    }

                    // 조건 2. maxheap의 최대값은 minheap의 최소값보다 작아야함
                    // 조건에 맞지 않으면 swap
                    if (maxHeap.size() > 0 && minHeap.size() > 0 && maxHeap.peek() >= minHeap.peek()) {
                        int a = maxHeap.poll();
                        int b = minHeap.poll();
                        maxHeap.add(b);
                        minHeap.add(a);
                    }
                }

                sum += maxHeap.peek();
                sum = sum % DIV;
            }

            sb.append("#").append(tc).append(" ").append(sum).append("\n");
        }

        System.out.print(sb);
    }
}