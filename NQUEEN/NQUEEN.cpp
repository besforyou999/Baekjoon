#include <iostream>

using namespace std;

void printSolution(int board[4][4]) {
	for (int i = 0; i < 4 ; i++ ) {
		for (int j = 0; j < 4; j++ ) {
			cout << " " << board[i][j]  << " ";
		}
		cout << endl;
	}
}

bool isSafe(int board[4][4], int row, int col) {
	
	int i, j;

	for (i = 0 ; i < col ; i++ ) 
		if ( board[row][i] )
			return false;

	for ( i = row, j = col; i >= 0 && j >= 0 ; i--, j--)
		if (board[i][j])
			return false;

	for (i = row, j = col ; i < 4 && j >= 0 ; i++, j--)
		if (board[i][j])
			return false;

	return true;
}


bool solveNQUtil(int board[4][4], int col) {

	if ( col >= 4 ) 
		return true;

	for (int i = 0; i < 4; i++ ) {
		if (isSafe(board, i, col)) {
			board[i][col] = 1;

			if (solveNQUtil(board, col + 1 ) )
				return true;

			board[i][col] = 0;
		}
	}

	return false;
}

bool solveNQ()
{
	int board[4][4] = { { 0, 0, 0, 0},
											{ 0, 0, 0, 0},
											{ 0, 0, 0, 0},
											{ 0, 0, 0, 0} };

	if (solveNQUtil(board, 0 ) == false ) {
		printf("Solution does not exist");
		return false;
	}

	printSolution(board);
	return true;
}


int main()
{
	solveNQ();
	return 0;
}
