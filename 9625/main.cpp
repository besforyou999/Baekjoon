#include <iostream>

using namespace std;

int a_num = 1, b_num;

void operate() {

	int temp = a_num;
	a_num = b_num;
	b_num += temp;
}



int main (void) {

	int K;
	cin >> K;

	for (int i = 0; i < K ; i++ ) 
		operate();

	cout << a_num << " " << b_num;

	return 0;
}
	
