import sys
from collections import deque
input = sys.stdin.readline
# 0 : north, 1 : east, 2 : south, 3 : west


def spinToLeft(direction):
    direction -= 1
    if direction < 0:
        direction = 3
    return direction


def checkIfCleaningIsNeeded(r, c, direction):
    if direction == 0:
        if r - 1 >= 0 and visited[r - 1][c] is False and graph[r - 1][c] == 0:
            return True
        else:
            return False
    elif direction == 1:
        if c + 1 < M and visited[r][c+1] is False and graph[r][c + 1] == 0:
            return True
        else:
            return False
    elif direction == 2:
        if r + 1 < N and visited[r + 1][c] is False and graph[r + 1][c] == 0:
            return True
        else:
            return False
    elif direction == 3:
        if c - 1 >= 0 and visited[r][c - 1] is False and graph[r][c - 1] == 0:
            return True
        else:
            return False


def nextPos(r, c, direction):
    if direction == 0:
        return r - 1, c
    elif direction == 1:
        return r, c + 1
    elif direction == 2:
        return r + 1, c
    else:
        return r, c - 1


def checkIfBackwardAvailable(r, c, direction):
    if direction == 0:
        if r + 1 < N and graph[r+1][c] == 0:
            return r + 1, c
        else:
            return -1, -1
    elif direction == 1:
        if c - 1 >= 0 and graph[r][c - 1] == 0:
            return r, c - 1
        else:
            return -1, -1
    elif direction == 2:
        if r - 1 >= 0 and graph[r-1][c] == 0:
            return r - 1, c
        else:
            return -1, -1
    elif direction == 3:
        if c + 1 < M and graph[r][c+1] == 0:
            return r, c + 1
        else:
            return -1, -1


N, M = map(int, input().split())
r, c, d = map(int, input().split())
graph = [[] for _ in range(N)]
for i in range(N):
    graph[i] = list(map(int, input().split()))

visited = [[False for _ in range(M)] for _ in range(N)]

queue = deque()
queue.append((r, c, d))

cleanedArea = 0

while queue:
    r, c, d = queue.popleft()
    if visited[r][c] is False:
        visited[r][c] = True        # 1. 현재 위치 청소
        cleanedArea += 1
    nextDir = d                 # 원래 방향 보존
    cleanNeeded = False
    for _ in range(4):
        nextDir = spinToLeft(nextDir)
        cleanNeeded = checkIfCleaningIsNeeded(r, c, nextDir)
        if cleanNeeded:
            nr, nc = nextPos(r, c, nextDir) # 2.1 회전한 방향으로 1칸 전진
            queue.append((nr, nc, nextDir))
            break
        # 2.2 왼쪽 청소 불가. 왼쪽 방향으로 회전

    if cleanNeeded is False:        # 4 방향 청소불가
        nr, nc = checkIfBackwardAvailable(r, c, d)
        if nr != -1 and nc != -1:
            queue.append((nr, nc, d))
        else:
            break

print(cleanedArea)


