import sys
from collections import deque

dr = [-1, -1, 0, 1, 1, 1, 0, -1]
dc = [0, 1, 1, 1, 0, -1, -1, -1]

N = int(input())

graph = []
for _ in range(N):
    graph.append(list(input()))

if N <= 2:
    print(0)
    sys.exit(0)

queue = deque()

r = 0
c = 0

for _ in range(N):
    graph[r][c] = int(graph[r][c])
    queue.append((r, c, graph[r][c]))
    c += 1

c -= 1
r += 1

for _ in range(N - 1):
    graph[r][c] = int(graph[r][c])
    queue.append((r, c, graph[r][c]))
    r += 1

r -= 1
c -= 1

for _ in range(N - 1):
    graph[r][c] = int(graph[r][c])
    queue.append((r, c, graph[r][c]))
    c -= 1

c += 1
r -= 1

for _ in range(N - 2):
    graph[r][c] = int(graph[r][c])
    queue.append((r, c, graph[r][c]))
    r -= 1


while queue:
    r, c, cnt = queue.popleft()

    # 0이면 주변 # 모두 공백으로 변환
    if cnt == 0:
        for i in range(8):
            nr = r + dr[i]
            nc = c + dc[i]
            if 0 <= nr < N and 0 <= nc < N:
                if graph[nr][nc] == '#':
                    graph[nr][nc] = ' '
        continue

    # 1 이상이면 주변에 몇개의 #이 있는지 파악하고 #의 개수가 숫자보다 크면 판단 유보
    sharp = []
    mine = []
    # 주변 # 탐색
    for i in range(8):
        nr = r + dr[i]
        nc = c + dc[i]
        if 0 <= nr < N and 0 <= nc < N:
            if graph[nr][nc] == '#':
                sharp.append((nr, nc))
            elif graph[nr][nc] == '*':
                mine.append((nr, nc))

    mine_cnt = cnt - len(mine)

    if mine_cnt == 0 and sharp:
        for ele in sharp:
            nr, nc = ele
            graph[nr][nc] = ' '
        continue

    if mine_cnt < len(sharp):   # 판단 유보
        queue.append((r, c, cnt))
    elif mine_cnt == len(sharp): # 샾 개수만큼 숫자 있음
        for ele in sharp:
            nr, nc = ele
            graph[nr][nc] = '*'


# '*' + '#' 개수가 정답
cnt = 0
for r in range(N):
    for c in range(N):
        if graph[r][c] == '*' or graph[r][c] == '#':
            cnt += 1

print(cnt)