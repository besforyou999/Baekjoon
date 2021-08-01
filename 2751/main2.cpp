#include <stdio.h>
#include <stdlib.h>
#include <iostream>

using namespace std;

void swap(int *a, int *b) {
	int temp = *a;
	*a = *b;
	*b = *a;
}

static void downheap (int a[], int left, int right) {

	int temp = a[left]; // root
	int child;
	int parent;

	for (parent = left; parent < ( right + 1 ) / 2 ; parent = child ) {
		int cl = parent * 2 + 1; // 왼쪽 자식
		int cr = cl + 1;
		
		child = ( cr <= right && a[cr] > a[cl] ) ? cr : cl;
		
		if ( temp >= a[child] ) break;
		
		a[parent] = a[child];
	}
	a[parent] = temp;
}

void heapsort( int a[], int n ) {

	int i;

	for ( i = ( n - 1 ) / 2; i >= 0 ; i-- )
		downheap( a, i, n - 1 );
	for( i = n - 1 ; i > 0 ; i-- ) {
		swap( a[0], a[i] );
		downheap(a, 0, i - 1 );
	}

}

int main(void) {

	int n ;
	cin >> n;

	int * x = (int*)malloc(sizeof(int) * n );

	for (int i = 0; i < n ;i++ ) 
		scanf("%d", &x[i]);
	
	heapsort(x, n);

	for (int i = 0; i < n ;i++ ) 
		printf("%d\n", x[i]);

	free(x);
}



