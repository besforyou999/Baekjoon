#include <iostream>
#include <cstring>

using namespace std;

typedef long long ll;

ll mat[65][10];

void solve(int n) {

	memset(mat, 0, sizeof(mat));	

	for (int i = 0 ; i < 10 ; i++)
		mat[1][i] = i + 1;

	for (int i = 2 ; i <= n ; i++) {
		mat[i][0] = 1;
		for (int j = 1; j < 10 ; j++) 
			mat[i][j] = mat[i-1][j] + mat[i][j-1];
	}
	cout << mat[n][9] << endl;
}


int main (void) {

	int T, n;
	cin >> T;

	while (T--) {
		cin >> n;
		solve(n);	
	}
	return 0;

}
