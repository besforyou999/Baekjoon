from collections import deque


dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]


def bfs(start, end, maps, N, M):
    
    sr, sc = start
    
    visit = [[False] * M for _ in range(N)]
    visit[sr][sc] = True
    
    queue = deque()
    queue.append((sr, sc, 0))
    
    while queue:
        r, c, cnt = queue.popleft()
        
        if (r, c) == (end):
            return cnt
        
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            if 0 <= nr < N and 0 <= nc < M and not visit[nr][nc] and not maps[nr][nc] == 'X':
                visit[nr][nc] = True
                queue.append((nr, nc, cnt + 1))
    
    return -1


def solution(maps):
    answer = 0
    
    N = len(maps)
    M = len(maps[0])
    
    start, end, lever = (0, 0), (0, 0), (0, 0)
    
    for r in range(N):
        for c in range(M):
            val = maps[r][c]
            if val == 'S':
                start = (r, c)
            elif val == 'L':
                lever = (r, c)
            elif val == 'E':
                end = (r, c)
    
    to_lever = bfs(start, lever, maps, N, M)
    to_exit = bfs(lever, end, maps, N, M)
    
    if to_lever == -1 or to_exit == -1:
        answer = -1
    else:
        answer = to_lever + to_exit
    
    return answer