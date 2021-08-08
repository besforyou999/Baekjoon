#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(string & a, string & b) {
	
	int a_len = a.length();
	int b_len = b.length();

	if ( a_len < b_len ) {
		return true;
	}
	else if ( a_len == b_len ) {
		return a < b;
	}
	else 
		return false;
}	

int main (void) {

	int n;
	cin >> n;

	vector<string> v;

	string temp;

	for (int i = 0; i < n ; i++ ) {
		cin >> temp;
		v.push_back(temp);
	}

	sort(v.begin() , v.end() , compare);

	temp = v[0];	

	cout << temp << endl;

	for (int i = 1; i < n ; i++ ) {
		string current = v[i];
		if ( temp == current ) {
			continue;
		}
		cout << current << endl;
		temp = current;
	}
	
}
