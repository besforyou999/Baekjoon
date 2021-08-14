#include <iostream>

using namespace std;

int A[505][505], N = 0 , M = 0;

int dp[505][505];

void swap(int *a, int *b) {
	int temp = *a;
	*a = *b;
	*b = temp;
}

int find_max(int a, int b) {
	if ( a > b )
		return a;
	else
		return b;
}

int main(void) {

	ios_base::sync_with_stdio(false);
	cout.tie(NULL);
	cin.tie(NULL);

	cin >> N;

	for (int i = 1; i <= N; ++i)
		for (int j = 1 ; j <= i ; ++j)
			cin >> A[i][j];

	dp[1][1] = A[1][1];

	int bigger = 0;
	int max = 0;
	for (int i = 2; i <= N; ++i)
		for (int j = 1 ; j <= i ; ++j) 
			dp[i][j] = find_max(dp[i-1][j-1] , dp[i-1][j]) + A[i][j];	

	for (int i = 1 ; i <= N; ++i)
		M = find_max(M, dp[N][i]);	
	
	cout << M ;

	return 0;
}

