from collections import deque
import sys
input = sys.stdin.readline

N = int(input())
graph = [[0 for _ in range(N + 1)] for _ in range(N + 1)]
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]


def bfs(row, col, height):
    visited[row][col] = True
    queue = deque()
    queue.append((row, col))

    while queue:
        y, x = queue.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if ny < 1 or nx < 1 or ny > N or nx > N:
                continue
            if graph[ny][nx] <= height or visited[ny][nx]:
                continue
            visited[ny][nx] = True
            queue.append((ny, nx))


max_height = 0

for row in range(1, N + 1):
    lis = list(map(int, input().split()))
    for col in range(1, N + 1):
        val = lis[col - 1]
        graph[row][col] = val
        if val > max_height:
            max_height = val

ans = 0

for height in range(max_height + 1):
    safe_area = 0
    visited = [[False for _ in range(N + 1)] for _ in range(N + 1)]
    for row in range(1, N + 1):
        for col in range(1, N + 1):
            if graph[row][col] > height and visited[row][col] is False:
                bfs(row, col, height)
                safe_area += 1
    if safe_area > ans:
        ans = safe_area

print(ans)

