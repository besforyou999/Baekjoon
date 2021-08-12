#include <stdio.h>

int main(void) {

	int DP[11];

	DP[1] = 1;
	DP[2] = 2;
	DP[3] = 4;

	int T;
	scanf("%d\n", &T);

	int N;	
	for (int i = 0; i < T; i++) {
		scanf("%d\n", &N);
		for (int j = 4 ; j <= N; j++) {
			DP[j] = DP[j-3] + DP[j-2] + DP[j-1];			
		}
		printf("%d\n", DP[N]);
	}
}

