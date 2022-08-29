import sys
input = sys.stdin.readline

R, C = map(int, input().split())
graph = []
for _ in range(R):
    graph.append(list(input()))
answer = 0
alpha_set = set()
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]


def dfs(x, y, count):
    global answer
    answer = max(answer, count)
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < R and 0 <= ny < C and not graph[nx][ny] in alpha_set:
            alpha_set.add(graph[nx][ny])
            dfs(nx, ny, count + 1)
            alpha_set.remove(graph[nx][ny])


alpha_set.add(graph[0][0])
dfs(0, 0, 1)
print(answer)


