#include <stdio.h>

int dp[1001] = {0 , 1, 3};

int f(int n) {
	if (dp[n])
		return dp[n];

	return dp[n] = ( f(n-1) % 10007 + 2 * f(n-2) % 10007 ) % 10007;
}


int main (void) {

	int n;
	scanf("%d",&n);

	int t = f(n);
	printf("%d\n", t);

	return 0;
}
