from sys import stdin
from itertools import combinations

n, m = map(int, stdin.readline().rstrip().split())

house = []
chicken_store = []
chicken_range = []

def get_chicken_range(y, x, pos):
    result = 1000000
    for item in pos:
        val = abs(y - item[0]) + abs(x - item[1])
        result = min(result, val)
    return result

for i in range(n):
    line = list(map(int, stdin.readline().rstrip().split()))
    for j in range(n):
        val = line[j]
        if val == 1:
            house.append([i+1, j+1])
        elif val == 2:
            chicken_store.append([i+1, j+1])

ans = 1000000

picked_chicken_store_coords = list(combinations(chicken_store, m))

for pos in picked_chicken_store_coords:
    temp = 0
    for coord in house:
        temp += get_chicken_range(coord[0], coord[1], pos)
    ans = min(ans, temp)

print(ans)
