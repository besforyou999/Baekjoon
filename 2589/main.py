import copy
from sys import stdin
from collections import deque

n, m = map(int, stdin.readline().rstrip().split())
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

graph = [[0 for _ in range(m)] for _ in range(n)]


def bfs(y, x):
    visited = [[0 for _ in range(m)] for _ in range(n)]
    queue = deque([])
    queue.append([y, x])
    visited[y][x] = 1
    longest_length = -1
    while queue:
        y, x = queue.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if ny < 0 or nx < 0 or ny >= n or nx >= m:
                continue
            if graph[ny][nx] == 'W' or visited[ny][nx] != 0:
                continue
            visited[ny][nx] = visited[y][x] + 1
            longest_length = max(longest_length, visited[ny][nx])
            queue.append([ny, nx])
    return longest_length - 1


for i in range(n):
    line = stdin.readline().rstrip()
    for j in range(m):
        graph[i][j] = line[j]

answer = -1

for i in range(n):
    for j in range(m):
        if graph[i][j] == 'L':
            answer = max(answer, bfs(i, j))

print(answer)
