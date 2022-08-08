import sys
from itertools import combinations
input = sys.stdin.readline

while True:
    line = list(map(int, input().rstrip().split()))
    if line[0] == 0:
        break

    k = line[0]
    numbers = line[1:]
    combos = list(combinations(numbers, 6))
    for item in combos:
        answer = ""
        for i in range(6):
            answer += (str(item[i]) + " ")
        print(answer)
    print()

