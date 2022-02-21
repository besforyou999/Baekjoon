import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw;
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		Node[] nodes = new Node[N+1];

		for (int i = 1 ; i <= N ; i++) nodes[i] = new Node(i);

		StringTokenizer st;

		for (int i = 0 ; i < N - 1 ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			nodes[a].adj.add(nodes[b]);
			nodes[b].adj.add(nodes[a]);
		}	

		// BFS
		boolean [] visited = new boolean[N+1];

		Queue<Node> queue = new LinkedList<>();
		nodes[1].root = -1; //root 
		queue.add(nodes[1]);

		while(!queue.isEmpty()) {
			Node n = queue.poll();

			for (Node node : n.adj ) {
				if(!visited[node.idx]) {
					visited[node.idx] = true;
					node.root = n.idx;
					queue.add(node);
				}
			}
		}
		
		for (int i = 2 ; i <= N ; i++) {
			bw.write(nodes[i].root + "\n");
		}
		bw.flush();
		bw.close();
	}
}

class Node {
	int idx;
	int root;
	ArrayList<Node> adj;

	public Node(int idx) {
		this.idx = idx;
		this.root = 0;
		this.adj = new ArrayList<>();
	}
}	

