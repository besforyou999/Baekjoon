#include <iostream>
#include <algorithm>
#include <limits>

using namespace std;

typedef long long ll;

const int MAX = 100000;
const int INF = numeric_limits<int>::max();

int arr[MAX];

int main() {

  int N , S;

  cin >> N >> S;

  for (int i = 0; i < N ; i++)
    cin >> arr[i];

  int low = 0, high = 0;
  int sum = arr[0];
  int result = INF;

  while (low <= high && high < N) {

	if (sum < S) {
	  sum += arr[++high];
	} else if (sum == S) {
	  result = min(result, high - low + 1);
	  sum += arr[++high];
	} else if (sum > S) {
	  result = min(result, high - low + 1);
	  sum -= arr[low++];
	}

  }


  if ( result == INF) {
    cout << 0;
  }
  else
    cout << result;

  return 0;
}
