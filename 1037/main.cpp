#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void) {
	int count;
	cin >> count;

	vector<int> v ;

	for (int i = 0 ; i < count ; i++ ) {
		int temp ;
		cin >> temp;
		v.push_back(temp);
	}

	sort(v.begin(), v.end());

	long long ans = (long long)v[0] * (long long) v[count-1];

	cout << ans;
}
