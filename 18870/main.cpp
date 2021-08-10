#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int b_search(vector<int> & v, int x) {


	int l = 0 , r = v.size() - 1;

	int mid = 0;
		
	while ( l <= r ) {
		
		mid = ( l + r ) / 2;

		if ( v[mid] < x ) {
			l = mid + 1;
		}
		else if ( v[mid] > x ) {
			r = mid - 1;
		}
		else 
			return mid;

	}

return -1;
}


int main (void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int n;
	cin >> n;

	vector<int> v(n);
	vector<int> plain_v(n);

	int temp = 0;
	
	for (int i = 0; i < n ; i++ ) {
		cin >> temp;
		v[i] = temp;
		plain_v[i] = temp;
	}

	sort(v.begin(), v.end());
	
	v.erase(unique(v.begin(), v.end()), v.end());

	
	for (int i = 0; i < n ; i++ ) {
		int x = plain_v[i];
		
		cout << b_search(v, x) << " ";
		
	}		

	return 0;	
}


