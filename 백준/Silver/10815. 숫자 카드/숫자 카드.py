from collections import deque
import sys

N = int(input())
cards = sorted(list(map(int, sys.stdin.readline().split(" "))))

M = int(input())
numbers = list(map(int, sys.stdin.readline().split(" ")))

for number in numbers:

    left, right = 0, N - 1
    exist = False

    while left <= right:
        mid = (left + right) // 2

        if cards[mid] < number:
            left = mid + 1
        elif cards[mid] > number:
            right = mid - 1
        else:
            exist = True
            break

    print(1 if exist else 0, end=' ')