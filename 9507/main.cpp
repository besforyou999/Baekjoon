#include <iostream>

using namespace std;

typedef long long ll;

int main (void) {
	ll arr[71];
	int t;
	int temp;
	arr[0] = 1;
	arr[1] = 1;
	arr[2] = 2;
	arr[3] = 4;

	cin >> t;
	
	for (int i = 4 ; i <= 70 ; i++ ) 
		arr[i] = arr[i-1] + arr[i-2] + arr[i-3] + arr[i-4];
	
	while (t--) {
		cin >> temp;
		cout << arr[temp] << endl;	
	}

return 0;
}
