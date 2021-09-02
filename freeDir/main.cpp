#include <iostream>

using namespace std;

int dp[1001];
int parr[1001];
int N;

int Bigger(int A, int B) { if (A>B) return A; return B;}

int main (void) {

	cin >> N;

	for (int i = 1; i<= N ; i++) cin >> parr[i];

	for (int i = 1; i <= N ; i++ ) {
		for (int j = 1 ; j <= i ; j++ ) {
			dp[i] = Bigger(dp[i], dp[i-j] + parr[j]);
		}
	}

	cout << dp[N] << endl;
	
	return 0;
}	
		

			
	
