#include <iostream>

using namespace std;

const int MAX = 100;

int A[MAX][MAX];
int B[MAX][MAX];
int result[MAX][MAX];
int N = 0, M = 0, K = 0;

void multiple(int i, int j , int m);

int main(void) {

	int N, M, K;

	cin >> N >> M;

	for (int i = 0; i < N; i++)
		for (int j = 0; j < M; j++)
			cin >> A[i][j];

	cin >> M >> K;

	for (int i = 0; i < M; i++)
		for (int j = 0; j < K; j++)
			cin >> B[i][j];

	int m = M;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < K; j++) {
			multiple(i, j , m);			
		}		
	}
	
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < K; j++) {
			cout << result[i][j] << " ";
		}
		cout << endl;
	}
	
}


void multiple(int i, int j, int m) {
	int sum = 0;
	for (int a = 0; a < m; a++) {
		sum += A[i][a] * B[a][j];
		
	}
	
	result[i][j] = sum;
}