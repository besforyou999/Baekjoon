#include <iostream>
#include <queue>
using namespace std;

const int MAX = 101;
int mat[MAX][MAX];
bool visited[MAX][MAX];
int path[MAX][MAX];
int dy[] = { 0, 0, -1, 1};
int dx[] = { 1, -1, 0, 0};
int N, M;
queue<pair<int, int> > q;


void printPath() {
	for ( int i = 0 ; i < N ; i++) {
		for ( int j = 0 ; j < M ; j++ ) {
			printf("%2d ", path[i][j]);
		}
		printf("\n");
	}
	printf("\n");
}

void BFS(int y, int x) {
	
	path[y][x] = 1;
	visited[y][x] = true;
	q.push(make_pair(y,x));

	while( !q.empty() ) {
	
		y = q.front().first;
		x = q.front().second;
		q.pop();

		for ( int i = 0 ; i < 4 ; i++ ) {
			
			int ny = y + dy[i];
			int nx = x + dx[i];

			if ( ny < 0 || nx < 0 || ny >= N || nx >= M ) 
				continue;
			if ( mat[ny][nx] == 1 && visited[ny][nx] == 0 ) {
				visited[ny][nx] = true;
				q.push(make_pair(ny, nx));
				path[ny][nx] = path[y][x] + 1;
			}
		}
	}
}


int main (void) {
	
	cin >> N >> M;

	string input;

	for ( int i = 0 ; i < N ; i++ ) {
		cin >> input;
		for ( int j = 0 ; j < M ; j++ ) {
			mat[i][j] = input[j] -'0';
		}
	}
			
	BFS(0, 0);
	cout << path[N-1][M-1];

	return 0;
}
