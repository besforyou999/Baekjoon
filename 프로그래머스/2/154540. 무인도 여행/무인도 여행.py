from collections import deque

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]


def bfs(r, c, visit, maps, R, C):
    queue = deque()
    queue.append((r, c))
    visit[r][c] = True
    result = int(maps[r][c])
    
    while queue:
        r, c = queue.popleft()
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            if 0 <= nr < R and 0 <= nc < C and not visit[nr][nc] and maps[nr][nc] != 'X':
                visit[nr][nc] = True
                result += int(maps[nr][nc])
                queue.append((nr, nc))
    
    return result


def solution(maps):
    answer = []
    
    R = len(maps)
    C = len(maps[0])
    
    visit = [[False] * C for _ in range(R)]
    
    for r in range(R):
        for c in range(C):
            if not visit[r][c] and maps[r][c] != 'X':
                answer.append(bfs(r, c, visit, maps, R, C))
    
    if not answer:
        answer.append(-1)
    
    answer.sort()
    
    return answer