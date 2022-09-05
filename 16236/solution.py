import sys
from collections import deque
from functools import cmp_to_key

input = sys.stdin.readline


class fish:
    def __init__(self, size, row, col):
        self.size = size
        self.row = row
        self.col = col
        self.ate = 0
        self.distance = 0

    def eatFish(self):
        self.ate += 1
        if self.ate == self.size:
            self.size += 1
            self.ate = 0


dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

N = int(input())
graph = [[0 for _ in range(N)] for _ in range(N)]
fish_arr = []
baby_shark= fish(2, 0, 0)

for i in range(N):
    line = list(map(int, input().split()))
    for j in range(N):
        val = line[j]
        graph[i][j] = val
        if 1 <= val <= 6:
            fish_arr.append(fish(val, i, j))
        elif val == 9:
            baby_shark.row = i
            baby_shark.col = j


if len(fish_arr) == 0:
    print(0)
    sys.exit(0)


def findSmallerFishForBabyShark():
    result = []
    visited = [[0 for _ in range(N)] for _ in range(N)]
    queue = deque()
    queue.append((baby_shark.row, baby_shark.col))
    visited[baby_shark.row][baby_shark.col] = 1

    while queue:
        y, x = queue.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if ny < 0 or nx < 0 or nx >= N or ny >= N:
                continue
            if visited[ny][nx] != 0:
                continue
            if graph[ny][nx] > baby_shark.size:
                continue
            visited[ny][nx] = visited[y][x] + 1
            if graph[ny][nx] != 0 and graph[ny][nx] < baby_shark.size:
                fish_size = graph[ny][nx]
                tmp = fish(fish_size, ny, nx)
                tmp.distance = visited[ny][nx] - 1
                result.append(tmp)
            queue.append((ny, nx))

    return result


def eatFishAndMoveBShark(fish):
    graph[baby_shark.row][baby_shark.col] = 0
    graph[fish.row][fish.col] = 9
    baby_shark.row = fish.row
    baby_shark.col = fish.col
    baby_shark.eatFish()


def findClosestFish(fishArr):
    result = []
    minimumDistance = 10000000

    for ele in fishArr:
        dist = ele.distance
        minimumDistance = min(dist, minimumDistance)

    for ele in fishArr:
        if minimumDistance == ele.distance:
            result.append(ele)

    if len(result) == 1:
        return result[0]

    result = chooseHighestFish(result)

    if len(result) == 1:
        return result[0]

    result = chooseMostLeftFish(result)

    return result[0]


def chooseHighestFish(fishArr):
    result = []

    highestRow = 10000000

    for ele in fishArr:
        highestRow = min(highestRow, ele.row)

    for ele in fishArr:
        if ele.row == highestRow:
            result.append(ele)

    return result


def chooseMostLeftFish(fishArr):
    result = []

    mostLeftCol = 10000000

    for ele in fishArr:
        mostLeftCol = min(mostLeftCol, ele.col)

    for ele in fishArr:
        if ele.col == mostLeftCol:
            result.append(ele)

    return result


answer = 0


while True:
    # check if there is fish that baby shark can eat
    smallerFishArr = findSmallerFishForBabyShark()
    if len(smallerFishArr) == 0: # no smaller fish to eat
        break
    elif len(smallerFishArr) == 1:
        answer += smallerFishArr[0].distance
        eatFishAndMoveBShark(smallerFishArr[0])
    else:
        closestFish = findClosestFish(smallerFishArr)
        answer += closestFish.distance
        eatFishAndMoveBShark(closestFish)

print(answer)



