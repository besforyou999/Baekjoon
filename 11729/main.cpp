#include <stdio.h>
#include <cmath.h>

void hanoi(int n, int start, int mid, int end) {

	if (n == 1) 
	{
		cout << start << " " << end << endl;
		return ;
	}

	hanoi(n - 1, start, end, mid);
	hanoi(1, start, mid, end);
	hanoi(n - 1, mid, start, end);
}

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;
	cin >> N;

	int cnt = pow(2,N) - 1;

	cout << cnt << endl;
	hanoi(N, 1, 2, 3);

	return 0;
}
