#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {

	int n;
	cin >> n;

	vector<int> v;

	int N = n;

	while (N--) {
		int temp;
		cin >> temp;
		v.push_back(temp);
	}

	int x;
	cin >> x;

	sort(v.begin(), v.end());

	int lp = 0;
	int rp = n - 1;
	int ans = 0;

	while (lp < rp) {

		if (v[lp] + v[rp] < x) {
			lp++;
		}
		else if (v[lp] + v[rp] == x) {
			ans++;
			rp--;
		}
		else if (v[lp] + v[rp] > x) {
			rp--;
		}
	}

	cout << ans;

}