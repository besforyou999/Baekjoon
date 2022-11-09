import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int node;
    double dis;
    Edge (int node, double dis) {
        this.node = node;
        this.dis = dis;
    }

    @Override
    public int compareTo(Edge e1) {
        return Double.compare(this.dis, e1.dis);
    }
}


public class Main {
    static int V, E;
    static ArrayList<ArrayList<Edge>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0 ; i <= V ; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0 ; i < E ; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            double C = Double.parseDouble(st.nextToken());
            graph.get(A).add(new Edge(B, C));
            graph.get(B).add(new Edge(A, C));
        }

        double ans = prim(1);
        System.out.print((int)ans);
    }
    public static double prim(int sV) {
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.add(new Edge(sV, 0)); // 시작 정점 저장
        boolean visited[] = new boolean[V+1]; // 해당 정점을 간선으로 연결해줬는지 확인
        Edge e;
        double totW = 0;
        while(!pQ.isEmpty()) {
            e = pQ.remove(); // 간선
            if(!visited[e.node]) { // 방문 유무에 따라 그래프에 사이클이 생기는지가 결정
                visited[e.node] = true;
                totW += e.dis;
                for(Edge next : graph.get(e.node))
                    if(!visited[next.node])
                        pQ.add(next); // 방문하지 않은 해당 정점으로 부속된 간선 큐에 저장
            }
        }
        return totW; // MST 가중치 합
    }
}

