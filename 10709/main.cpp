#include <iostream>
#include <cstring>
using namespace std;
// 1
char cloud[101][101];
int ans[101][101];

int main (void) {
	
	int H,W;
	cin >> H >> W;
	// 2
	memset(ans, -1, sizeof(ans));
	// 3
	for (int i = 1; i <= H ; i++) {
		for (int j = 1; j <= W ; j++ ) 
			cin >> cloud[i][j];
	}
	// 4
	for (int i = 1; i <= H ; i++) {
		for (int j = 1; j <= W ; j++ ) {
			if ( cloud[i][j] == 'c' ) { //4 - 1
				ans[i][j] = 0;
			}
			else if	( cloud[i][j] == '.' && ans[i][j-1] != -1 ) { //4 - 2
				ans[i][j] = ( ans[i][j-1] + 1 );
			}
			cout << ans[i][j] << " ";
		}
		cout << endl;
	}
	return 0;
}

