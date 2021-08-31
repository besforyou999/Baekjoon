#include <iostream>

using namespace std;

const int DIV = 10007;
const int MAX = 1001;

int main (void) {

	int n;
	cin >> n;

	int arr[MAX];

	arr[0] = 0;
	arr[1] = 1;
	arr[2] = 3;

	if ( n <= 2 ) {
		cout << arr[n];
		return 0;
	}

	for (int i = 3 ; i <= n ; i++ ) 
		arr[i] = ( arr[i-1] % DIV + 2 * arr[i-2] % DIV ) % DIV;

	cout << arr[n];

return 0;
}

	
