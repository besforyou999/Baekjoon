#include <iostream>

using namespace std;

int mat[1001][1001];

int get_max(int a, int b, int c) {
	
	int max = 0;
	if ( max < a ) max = a;
	if ( max < b ) max = b;
	if ( max < c ) max = c;
	return max;

}

int main (void) {

	int N , M;
	cin >> N >> M;

	int temp = 0;
	int max = 0;

	for (int i = 1 ; i <= N ; i++ ) {
		for (int j = 1; j <= M ; j++ ) {
			cin >> temp;
			max = get_max(mat[i-1][j-1] , mat[i][j-1], mat[i-1][j]);
			mat[i][j] = temp + max;
		}
	}

	cout << mat[N][M];
	
}	

	
