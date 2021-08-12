#include <stdio.h>

int main(void) {

	int P, M, N;

	scanf("%d", &P);

	int cnt, a, b;

	for (int i = 0; i < P ; i++ ) {
		scanf("%d %d", &N, &M);
		cnt = 0;
		a = b = 1;

		while (1) {
			int temp = (a + b) % M;
			a = b;
			b = temp;
			cnt++;

			if (a == 1 && b == 1 ) break;
		}

		printf("%d %d\n", N, cnt);
	}

	return 0;
}
