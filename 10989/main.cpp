#include <iostream>
#include <algorithm>

using namespace std;

int arr[10001];

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int n;
	cin >> n;

	int temp = 0;

	for (int i = 0; i < n ;i++ ) {
		cin >> temp;
		arr[temp] += 1;
	}

	for (int i = 0; i <= n ; i++ ) {
		for (int j = 0; j < arr[i] ; j++ ) {
			cout << i << endl;
		}
	}
}
		
	
