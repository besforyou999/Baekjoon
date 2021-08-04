#include<iostream>

using namespace std;

typedef long long ll;

int main (void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int n;
	cin >> n;

	int digit = 0;
	int temp_n = n;

	while ( temp_n > 0 ) {
		temp_n /= 10;
		digit++;
	}

	int constructor_min = n - digit * 9;

	if ( constructor_min < 0 ) constructor_min = 0;

	int ans = 0;


	int num, sum = 0;
	for (int i = constructor_min ; i <= n ; i++ ) {
		num = i;
		sum += num;

		while ( num > 0 ) {
		    sum += num % 10;
			num /= 10;
		}		

		if ( n == sum ) {
			ans = i;
			break;
		}
		sum = 0;
	}
		
	cout << ans;

	return 0;
}
	
