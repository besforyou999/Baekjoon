#include <iostream>

using namespace std;

const int MAX = 21;
int N;
int L_arr[MAX];
int J_arr[MAX];

int main (void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;

	for (int i = 1; i <= N ; i++) 
		cin >> L_arr[i];

	for (int i = 1; i <= N ; i++) 
		cin >> R_arr[i];

	int max = -1;

	int dp[MAX][MAX]; // current life, current happyness

	for (int i = 1; i <= N ; i++) {
		for (int j = 1; j <= i ; j++) {
			if ( 	


	return 0;
}	
