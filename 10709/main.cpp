#include <cstring>
#include <iostream>
using namespace std;
char cloud[101][101];
int ans[101][101];
int main (void) {
	
	int H,W;
	cin >> H >> W;
	memset(ans, -1, sizeof(ans));
	for (int i = 1; i <= H ; i++) {
		for (int j = 1; j <= W ; j++ ) 
			cin >> cloud[i][j];
	}
	for (int i = 1; i <= H ; i++) {
		for (int j = 1; j <= W ; j++ ) {
			if ( cloud[i][j] == '.' && ans[i][j-1] == -1 ) {
				ans[i][j] = -1;
			}
			else if ( cloud[i][j] == '.' && ans[i][j-1] != -1 ) {
				ans[i][j] = ( ans[i][j-1] + 1 );
			}
			else if (cloud[i][j] == 'c') {
				ans[i][j] = 0;
			}
			cout << ans[i][j] << " ";
		}
		cout << endl;
	}

	return 0;
}

