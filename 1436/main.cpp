#include <iostream>
#include <string>

using namespace std;

int main(void) {

	int n ;
	cin >> n;

	int count = 0;
	int start = 666;

	while (count < n) {
		string str = to_string(start);
	
		if (str.find("666") != -1) {
			count++;
		}

		start++;
	}

	cout << start - 1 << endl;
}
