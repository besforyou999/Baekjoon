from itertools import combinations
import sys
input = sys.stdin.readline

N, M = map(int, input().split())


def chickenDistance(house, store):
    total = 0
    for coord in house:
        row = coord[0]
        col = coord[1]
        dist = 100000
        for cod in store:
            c_dist = abs(row - cod[0]) + abs(col - cod[1])
            dist = min(dist, c_dist)
        total += dist
    return total


house = []
chicken = []

for row in range(N):
    line = list(map(int, input().split(' ')))
    for col in range(N):
        val = line[col]
        if val == 1:
            house.append([row, col])
        elif val == 2:
            chicken.append([row, col])

combination = combinations(chicken, M)

answer = 1000000

for combo in combination:
    c_dist = chickenDistance(house, combo)
    answer = min(answer, c_dist)

print(answer)