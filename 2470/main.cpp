#include <iostream>
#include <algorithm>
#include <climits>

using namespace std;

const int MAX = 100000;

int main() {

  int n ;
  cin >> n ;

  int len = n;

  long long ai[MAX];

  for (int i = 0; i < n ; i++)
	cin >> ai[i];

  sort(ai , ai + n);

  int lp = 0 , rp = len - 1;
  int l = 0 , r = len - 1;

  long long min = LLONG_MAX;

  while (l < r) {

	long long sum = ai[l] + ai[r];

	if ( llabs(sum) < min ) {

	  min = llabs(sum);
	  lp = l;
	  rp = r;
	}

	if ( sum < 0)
	  l++;
	else
	  r--;
  }

  cout << ai[lp] << " " << ai[rp];

  return 0;
}
