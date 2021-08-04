#include <iostream>

using namespace std;

int main(void) {

	int arr[50][2];

	int n;
	cin >> n;

	for (int i = 0; i < n ; i++ ) {
		int x , y;
		cin >> x >> y;

		arr[i][0] = x;
		arr[i][1] = y;
		
	}

	for (int i = 0 ; i < n ; i++ ) {

		int count = 0;

		for (int j = 0; j < n ; j++ ) {

			if ( arr[j][0] > arr[i][0] && arr[j][1] > arr[i][1] ) {
				count++;
			}

		}

		cout << ++count << " ";
	}

	return 0;
}
