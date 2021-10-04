#include <iostream>
#include <queue>

using namespace std;

const int MAX = 1001;
int mat[MAX][MAX];
int visited[MAX];
queue<int> q;
int N, M, V;

void clearArr() {
	for ( int i = 0 ; i < MAX ; i++ ) 
		visited[i] = false;
	cout << "\n";
}

void DFS(int v) {
	cout << v << " ";
	visited[v] = true;
	
	for ( int i = 1 ; i <= N ; i++ ) {
		if ( mat[v][i] != 0 && visited[i] == false ) {
			DFS(i);
		}
	}
	return ;
}

void BFS(int v) {

	q.push(v);
	visited[v] = true;

	while ( !q.empty() ) {
		v = q.front();
		cout << v << " ";
		q.pop();
		for ( int i = 1 ; i <= N ; i++ ) {
			if ( mat[v][i] != 0 && visited[i] == false ) {
				q.push(i);
				visited[i] = true;
			}
		}
	}
}

int main (void ) {
	cin >> N >> M >> V;
	int first, sec;
	for ( int i = 1 ; i <= M ; i++ ) {
		cin >> first >> sec;
		mat[first][sec] = mat[sec][first] = 1;
	}
	DFS(V);
	clearArr();
	BFS(V);	
	return 0;
}
