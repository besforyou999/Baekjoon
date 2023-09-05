import sys
N, M = map(int, input().split())


def dfs(num, depth):
    if depth == 4:
        print(1)
        sys.exit(0)

    for friend in person[num]:
        if not visit[friend]:
            visit[friend] = True
            dfs(friend, depth + 1)
            visit[friend] = False


person = [[] for _ in range(N)]

for _ in range(M):
    a, b = map(int, input().split())
    person[a].append(b)
    person[b].append(a)

for i in range(N):
    if person:
        visit = [False] * N
        visit[i] = True
        dfs(i, 0)

print(0)