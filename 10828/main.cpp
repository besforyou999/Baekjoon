#include <iostream>
#include <string>
using namespace std;

void push(int num);
int pop();
int empty();
int top();

int stack[10000];
int numCount = 0;

int main() {
  int n ;
  cin >> n ;

  for (int i = 0; i < n ; i++) {
    string order;
    cin >> order;

    if (order == "push") {
      int temp;
      cin >> temp;
      push(temp);
    }
    else if (order == "pop") {
      cout << pop() << endl;
    }
    else if (order == "size") {
      cout << numCount << endl;
    }
    else if (order == "empty") {
      cout << empty() << endl;
    }
    else if (order == "top") {
      cout << top() << endl;
    }

  }

  return 0;
}

void push(int num) {
  stack[numCount] = num;
  numCount++;
}
int pop() {
  if (numCount == 0) return -1;
  int temp = stack[numCount-1];
  stack[numCount-1] = 0;
  numCount--;
  return temp;
}
int empty() {
  if (numCount == 0) return 1;

  return 0;
}
int top() {
  if (numCount == 0) return -1;

  return stack[numCount-1];
}

