import sys
from itertools import combinations

input = sys.stdin.readline

N, L, R, X = map(int, input().rstrip().split())

levels = list(map(int, input().rstrip().split()))

count = 0

for problem_number in range(2, N+1):
    combos = combinations(levels, problem_number)
    for i in combos:
        picked_levels = list(sorted(i))
        total = sum(picked_levels)
        diff = abs(picked_levels[0] - picked_levels[-1])
        if L <= total <= R and diff >= X:
            count += 1


print(count)
