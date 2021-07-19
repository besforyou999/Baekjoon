#include <iostream>
#include <algorithm>

using namespace std;

int lower_binary(int* arr, int target, int size) {
	int mid, start, end;

	start = 0, end = size - 1;
	
	while (start < end) {
		mid = (start + end) / 2;
		if (arr[mid] >= target)
			end = mid;
		else
			start = mid + 1;
	}
	
	return end;
}

int upper_binary(int* arr, int target, int size) {
	int mid, start, end;
	start = 0, end = size - 1;

	while (start < end) {
		mid = (start + end) / 2;
		if (arr[mid] > target)
			end = mid;
		else
			start = mid + 1;
	}
	return end;
}

int main(void) {

	int N;
	cin >> N;
	
    int* arr = (int*)malloc(sizeof(int) * N);

	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}

	sort(arr, arr + N);
	
	int M;
	cin >> M;

	int* numToFind = (int*)malloc(sizeof(int) * M);
	

	for (int i = 0; i < M; i++) 
		cin >> numToFind[i];
		

	for (int i = 0; i < M; i++) {
		int lower = lower_binary(arr, numToFind[i], N);
		int upper = upper_binary(arr, numToFind[i], N);

		if (upper == N - 1 && arr[N - 1] == numToFind[i])
			upper++;

		cout << upper - lower << " ";
	}

	free(arr);
	free(numToFind);

}
