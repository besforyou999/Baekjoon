#include <iostream>
#include <stdlib.h>

using namespace std;

int *buff;

void __mergesort(int a[], int left, int right) {

	if ( left < right ) {

		int center = (left + right) / 2;

		int p = 0;
		int i;
		int j = 0;
		int k = left;

		__mergesort(a, left, center);
		__mergesort(a, center + 1, right);

		for (i = left; i <= center; i++)
			buff[p++] = a[i];
		while ( j < p && i <= right )
			a[k++] = ( buff[j] <= a[i] ) ? buff[j++] : a[i++];
		while ( j < p ) 
			a[k++] = buff[j++];

	}
}

int mergesort(int a[], int n) {

	if ( (buff = (int*)calloc(n , sizeof(int))) == NULL)
		return -1;

	__mergesort(a, 0, n-1);

	free(buff);
	return 0;
}

int main(void) {

	int n;
	cin >> n;

	int * arr = (int*)calloc(n, sizeof(int));

	for ( int i = 0; i < n ; i++ ) 
		cin >> arr[i];

	if (mergesort(arr,n) == -1 ) {
		cout << "Error";
		return -1;
	}
	
	for (int i = 0; i < n ; i++) {
		cout << arr[i] << endl;
	}
	free(arr);

	return 0;
}
