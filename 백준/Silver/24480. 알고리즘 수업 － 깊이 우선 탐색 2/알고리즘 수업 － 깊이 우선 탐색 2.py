import sys
sys.setrecursionlimit(10**6)

N, M, R = map(int , sys.stdin.readline().split())

graph = [[] for _ in range(N + 1)]

for _ in range(M):
    u, v = map(int, sys.stdin.readline().split())
    graph[u].append(v)
    graph[v].append(u)

for i in range(N + 1):
    graph[i].sort(reverse=True)


visit = [False] * (N + 1)

cnt = 1
answer = [0] * (N + 1)


def dfs(number):
    visit[number] = True
    global cnt
    answer[number] = cnt
    cnt += 1
    for num in graph[number]:
        if not visit[num]:
            dfs(num)


dfs(R)

for i in range(1, N + 1):
    print(answer[i])