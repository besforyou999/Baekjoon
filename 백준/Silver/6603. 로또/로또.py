import sys
from itertools import combinations

while True:
    numbers = list(map(int, sys.stdin.readline().rstrip().split()))
    if numbers[0] == 0:
        break
    k = numbers[0]
    numbers.pop(0)
    for combination in list(combinations(numbers, 6)):
        for num in combination:
            print(num, end=' ')
        print()
    print()