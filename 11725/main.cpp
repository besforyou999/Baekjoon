#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(void) {
  int N;
  cin >> N;

  vector<int> v;

  for (int i = 0; i < N ; i++) {
  	int temp;
    cin >> temp;
    v.push_back(temp);
  }

  sort(v.begin(), v.end());

  for (int i = 0 ; i < N ; i++)
    cout << v[i] << endl;

}



