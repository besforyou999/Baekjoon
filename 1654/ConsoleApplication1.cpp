#include <iostream>

using namespace std;

int xi[200000];

int main(void) {

	int N, C;
	cin >> N >> C;	

	for (int i = 0; i < N; i++) 
		cin >> xi[i];	

	int left = 1;
	int right = xi[N - 1] - xi[0];
	int len = right;
	int d = 0;
	int ans = 0;

	while (left <= right) {
		int mid = (left + right) / 2;

		d = len / mid;

		if (d < C)
			right = mid - 1;
		else
			left = mid + 1;
	}
	

}