import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, Q;
    static int arr[];
    static long tree[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        
        arr = new int[N + 1];
        tree = new long[N * 4];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1 ; i <= N ; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        init(1, N, 1);
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0 ; i < Q ; i++) {
            st = new StringTokenizer(br.readLine());
            
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if (x > y) {
                int tmp = x;
                x = y;
                y = tmp;
            }
            
            sb.append(sum(1, N , 1, x, y) + "\n");
            update(1, N , 1, a, b);
        }

        System.out.println(sb);
    }

    static long init(int start, int end, int node) {
        if (start == end) return tree[node] = arr[start];
        
        int mid = (start + end) / 2;
        
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }
    
    static long sum(int start, int end, int node, int left, int right) {
        if (end < left || right < start) return 0;
        if (left <= start && end <= right) return tree[node];
        
        int mid = (start + end) / 2;
        
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }
    
    static long update(int start, int end, int node, int index, long diff) {
        if (index < start || index > end)
            return tree[node];

        if (start == end)
            return tree[node] = diff;
        
        int mid = (start + end) / 2;
        return tree[node] =  update(start, mid, node * 2, index, diff) + update(mid + 1, end, node * 2 + 1, index, diff);
    }
}