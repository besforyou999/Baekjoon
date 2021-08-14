#include <iostream>

using namespace std;

int A[505][505], N , M;

int dp[505][505];

int main(void) {
	ios_base::sync_with_stdio(false);
	cout.tie(NULL);
	cin.tie(NULL);

	cin >> N;

	for (int i = 1; i <= N; ++i)
		for (int j = 1 ; j <= i ; ++j)
			cin >> A[i][j];

	for (int i = 1; i <= N; ++i) {
		for (int j = 1 ; j <= i ; ++j) {
			cout <<A[i][j] << " ";
		}
		cout << endl;
	}


	
	return 0;
}

