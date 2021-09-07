#include <iostream>

using namespace std;

typedef long long ll;

ll arr[36];

void operation(int n) {
	for (int i = 0; i < n ; i++) {
		arr[n] += arr[i] * arr[n - 1 - i];
	}
}	

int main (void) {

	int n;

	arr[0] = 1;	
	arr[1] = 1;
	arr[2] = 2;
	arr[3] = 5;
	
	cin >> n;

	if ( n <= 3 ) {
		cout << arr[n];
		return 0;	
	}

	for (int i = 4 ; i <= n ; i++) {
		operation(i);
	}

	cout << arr[n];
}
