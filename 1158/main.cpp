#include <iostream>
#include <vector>

using namespace std;

int main(void) {

	int n , k;
	cin >> n >> k;

	// 길이가 n인 배열
	vector<int> v(n); 
	
	// 배열에 1부터 n까지 저장
	for (int i = 0; i < n ; i++ ) {
		v[i] = i+1;
	}

	cout << "<";

	
	int counter = 0;
	int people_left = n;
	int index = 0;

	// 배열에 0밖에 남지 않을때까지 검색 반복
	while (people_left > 0 ) {

		int num = v[index];
		// 선형으로 검색한 원소가 0이 아닌 경우 count + 1
		if ( num != 0 ) {
			counter++;
		}
		// counter값이 k와 동일하면 출력, 배열의 원소값 0, 변수 초기화
		if (counter == k) {
			counter = 0;
			people_left--;
			v[index] = 0;
			//배열의 마지막값인 경우 쉼표없이 출력	
			if (people_left == 0) {
				cout << num;
			}
			else 
				cout << num << ", ";
		}

		index++;
		// index가 배열 끝까지 간 경우 배열 맨 처음으로
		if (index == n) index = 0;
	}
	cout << ">";
}

