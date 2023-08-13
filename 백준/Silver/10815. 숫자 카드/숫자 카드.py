from collections import deque
import sys

N = int(input())
cards = list(map(int, sys.stdin.readline().split(" ")))

M = int(input())
numbers = list(map(int, sys.stdin.readline().split(" ")))

_dict = {}

for i in cards:
    _dict[i] = True

for j in numbers:
    if j not in _dict:
        print(0, end=' ')
    else:
        print(1, end=' ')