#include <iostream>

using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, m, x;
	int x1, y1, x2, y2;
	int mat[1025][1025];
	
	cin >> n >> m;
		
	for (int i = 0; i < n ; i++ ) {
		for (int j = 0; j < n ; j++ ) {
			cin >> x;
			mat[i+1][j+1] = mat[i+1][j] + mat[i][j+1] - mat[i][j] + x;
		}
	}	

	for (int i = 0; i < m ; i++ ) {
		cin >> x1 >> y1 >> x2 >> y2;
	    cout << mat[x2][y2] - mat[x2][y1-1] - mat[x1-1][y2] + mat[x1-1][y1-1] << endl;
	}

	return 0;
}	
