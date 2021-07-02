#include <iostream>

using namespace std;

void swap(string *a, string *b) {
	string temp = *a;
	*a = *b;
	*b = temp;
}


void perm(string str, int l, int r ) {
	
	if ( l == r ) 
		cout << str << endl;
	else {
		for (int i = l; i <= r ; i++ ) {
			
			swap(str[l], str[i]);

			perm(str, l+1, r);

			swap(str[l], str[i]);
		}
	}

}

int main(void) {

	string str ="ABC";
	int n = str.size();
	perm(str, 0, n-1);
	return 0;
}
