#include <iostream>
#include <queue>

using namespace std;

const int MAX = 1001;

int mat[MAX][MAX];
int visit[MAX];
int N, M , V;

int main(void) {

	cin >> N >> M >> V;

	for ( int i = 0; i < M ; i++ ) {
		int first, second;
		cin >> first >> second;
		mat[first][second] = mat[second][first] = 1;
	}

}

void dfs (int v) {
	cout << v << " ";
	visit[v] = 1;
	for ( int i = 1; i <= N ; i++ ) {
		if ( visit[v] == 1 || mat[v][i] == 0 )
			continue;
		dfs(i);
	}
}	

void bfs (int v) {
	queue<int> q;
	visit[v] = 0;

}
