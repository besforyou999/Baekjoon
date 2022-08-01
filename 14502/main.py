import copy
from sys import stdin
from collections import deque
from itertools import combinations

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
n, m = map(int, stdin.readline().rstrip().split())
graph = [list(map(int, stdin.readline().rstrip().split())) for _ in range(n)]

virus = deque()
wall = deque()
point = []

for i in range(n):
    for j in range(m):
        if graph[i][j] == 2:
            virus.append([i, j])
        elif graph[i][j] == 1:
            wall.append([i, j])
        else:
            point.append([i, j])

answer = 0
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

for p in combinations(point, 3):
    one, two, three = p

    graph[one[0]][one[1]] = 1
    graph[two[0]][two[1]] = 1
    graph[three[0]][three[1]] = 1

    visit = [[False] * m for _ in range(n)]
    for v in virus:
        visit[v[0]][v[1]] = True

    queue = virus.copy()
    while queue:
        y, x = queue.popleft()
        for d in range(4):
            ny = y + dy[d]
            nx = x + dx[d]
            if ny < 0 or nx < 0 or ny >= n or nx >= m:
                continue
            if graph[ny][nx] == 0 and visit[ny][nx] == False:
                visit[ny][nx] = True
                queue.append([ny, nx])

    safe_area = 0

    for i in range(n):
        for j in range(m):
            if graph[i][j] == 0 and visit[i][j] == False:
                safe_area += 1

    answer = max(answer , safe_area)

    graph[one[0]][one[1]] = 0
    graph[two[0]][two[1]] = 0
    graph[three[0]][three[1]] = 0

print(answer)
