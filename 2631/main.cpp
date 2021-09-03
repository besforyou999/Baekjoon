#include <iostream>

using namespace std;

const int MAX = 201;
int N;
int kids[MAX];
int dp[MAX];

int main (void) {

	cin >> N;

	for ( int i = 1 ; i <= N ; i++ ) 
		cin >> kids[i];
	
	int ans = -1;

	for ( int i = 1 ; i <= N ; i++) {
		dp[i] = 1;
		for ( int j = 1 ; j <= i ; j++ ) {
			if ( kids[i] > kids[j] && dp[j] + 1 > dp[i] )
			   	dp[i] = dp[j] + 1;
		}
		if ( dp[i] > ans ) ans = dp[i];
	}

	cout << N - ans;

return 0;
}
			
