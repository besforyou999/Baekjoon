#include <iostream>
#include <cstring>

using namespace std;

const int MAX = 100 + 1;
int cache[MAX][MAX][2];
int N, K;

int seq(int len, int total, int bit) {

	// 기저 
	if ( len >= N || total > K )
		return 0;
	
	// 조건 충족
	if ( total == K || len == N-1)
		return 1;

	int &result = cache[len][total][bit];
	if (result != -1)
		return result;

	result = seq(len + 1, total, 0) + seq(len + 1, total + bit * 1, 1);
	return result;
}

int main (void) {

	int T;
	cin >> T;

	while (T--) {

		cin >> N >> K;

		memset(cache, -1 ,sizeof(cache));			

		cout << seq(0, 0, 0) + seq(0, 0, 1) << endl;

	}

	return 0;
}
		
