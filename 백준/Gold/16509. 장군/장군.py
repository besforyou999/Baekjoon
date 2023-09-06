import sys
from collections import deque

dr = [-3, -2, 2, 3, 3, 2, -2, -3]
dc = [2, 3, 3, 2, -2, -3, -3, -2]

movement = []
movement.append([(-1, 0), (-1, 1), (-1, 1)])
movement.append([(0, 1), (-1, 1), (-1, 1)])
movement.append([(0, 1), (1, 1), (1, 1)])
movement.append([(1, 0), (1, 1), (1, 1)])
movement.append([(1, 0), (1, -1), (1, -1)])
movement.append([(0, -1), (1, -1), (1, -1)])
movement.append([(0, -1), (-1, -1), (-1, -1)])
movement.append([(-1, 0), (-1, -1), (-1, -1)])

R1, C1 = map(int, input().split())
R2, C2 = map(int, input().split())

graph = [[0] * 9 for _ in range(10)]
visit = [[False] * 9 for _ in range(10)]
graph[R1][C1] = 1   # 상
graph[R2][C2] = 2   # 왕


def check_route(i, start_r, start_c):
    routes = []
    for t in range(3):
        start_r = start_r + movement[i][t][0]
        start_c = start_c + movement[i][t][1]
        routes.append(graph[start_r][start_c])

    return routes


queue = deque()
queue.append((R1, C1, 0))
visit[R1][C1] = True

while queue:
    r, c, move = queue.popleft()

    for i in range(8):
        nr = r + dr[i]
        nc = c + dc[i]

        if 0 <= nr < 10 and 0 <= nc < 9 and not visit[nr][nc]:
            routes = check_route(i, r, c)
            if routes[0] == routes[1] == 0:
                if routes[2] == 2:
                    print(move + 1)
                    sys.exit(0)
                elif routes[2] == 0:
                    visit[nr][nc] = True
                    queue.append((nr, nc, move + 1))

print(-1)