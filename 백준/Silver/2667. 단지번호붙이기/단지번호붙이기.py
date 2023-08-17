N = int(input())

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]
graph = []

for _ in range(N):
    graph.append(list(map(int, input())))

visited = [[False] * (N) for _ in range(N)]


def is_in(r, c):
    if 0 <= r < N and 0 <= c < N:
        return True


def dfs(r, c):
    if visited[r][c]:
        return

    visited[r][c] = True
    global count
    count += 1

    for i in range(4):
        nr = r + dr[i]
        nc = c + dc[i]
        if is_in(nr, nc) and graph[nr][nc] == 1:
            dfs(nr, nc)


nums = []
count = 0

for r in range(N):
    for c in range(N):
        if graph[r][c] == 1 and not visited[r][c]:
            count = 0
            dfs(r, c)
            nums.append(count)

nums.sort()

print(len(nums))
for i in nums:
    print(i)