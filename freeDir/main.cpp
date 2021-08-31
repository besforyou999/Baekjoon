#include <iostream>

using namespace std;

int N, M;
int mat[1025][1025];

int main(void) {

	ios_base::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);
	int temp , x1, y1, x2, y2;

	cin >> N >> M;

	for (int i = 1; i <= N ; i++ ) {
		for (int j = 1 ; j <= N ; j++ ) {
			cin >> temp;
			mat[i][j] = mat[i-1][j] + mat[i][j-1] - mat[i-1][j-1] + temp;			
		}
	}

	for (int i = 0 ; i < M ; i++ ) {

		cin >> x1 >> y1;
		cin >> x2 >> y2;

		cout <<	mat[x2][y2] - mat[x1-1][y2] - mat[x2][y1-1] + mat[x1-1][y1-1] << endl;
	}

	return 0;
}

		
