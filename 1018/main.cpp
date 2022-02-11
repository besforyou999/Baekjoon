#include <iostream>
#include <algorithm>
using namespace std;

char mat[51][51];
char mat_w[51][51];
char mat_b[51][51];

int MAX(int a, int b) {
	if ( a>= b) return a;
	return b;
}

int MIN(int a, int b) {
	if ( a <= b ) return a;
	return b;
}

void buildMat() {
	for (int i = 0 ; i < 51 ; i++) {
		for (int j = 0 ; j < 51 ; j++) {
			if ( (i + j) % 2 == 0 ) {
				mat_w[i][j] = 'W';
				mat_b[i][j] = 'B';
			}
			else {
				mat_w[i][j] = 'B';
				mat_b[i][j] = 'W';
			}
		}
	}		
}

int countChange(int i, int j) {

	int w_count = 0, b_count = 0;

	for (int a = 0 ; a < 8 ; a++) {
		for (int b = 0 ; b < 8 ;b++) {
			if (mat[i+a][j+b] != mat_w[i+a][j+b] ) w_count += 1;
			if (mat[i+a][j+b] != mat_b[i+a][j+b] ) b_count += 1;
		}
	}
	return MIN(w_count, b_count);
}

int main(void) {
	buildMat();	

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	
	int N, M;
	int ans = 1000000;
	cin >> N >> M;

	for (int i = 0 ; i < N ; i++) {
		for (int j = 0 ; j < M ; j++) {
			cin >> mat[i][j];
		}
	}

	for (int i = 0 ; i + 8 <= N ; i++) {
		for (int j = 0 ; j + 8 <= M ; j++) {
			int num = countChange(i,j);
			if (ans > num) ans = num;
		}
	}

	cout << ans;
	return 0;
}
