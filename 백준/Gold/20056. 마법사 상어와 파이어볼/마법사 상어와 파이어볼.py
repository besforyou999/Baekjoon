import sys

dr = [-1, -1, 0, 1, 1, 1, 0, -1]
dc = [0, 1, 1, 1, 0, -1, -1, -1]

N, M, K = map(int, sys.stdin.readline().split())

graph = [[[] for _ in range(N + 1)] for _ in range(N + 1)]
Fireball = []

for _ in range(M):
    ri, ci, mi, si, di = map(int, sys.stdin.readline().split())
    Fireball.append([ri - 1, ci - 1, mi, si, di])
    
for _ in range(K):

    # FB 모두 이동
    while Fireball:
        ri, ci, mi, si, di = Fireball.pop(0)
        nr = (ri + dr[di] * si) % N
        nc = (ci + dc[di] * si) % N
        graph[nr][nc].append([mi, si, di])
    
    # 그래프 완탐하면서 2개 이상 쌓인 FB 처리하고 다시 FB 배열에 추가
    for r in range(N):
        for c in range(N):
            fb_cnt = len(graph[r][c])
            if fb_cnt > 1:
                total_mass, total_speed, odd_dir, even_dir, cnt = 0, 0, 0, 0, fb_cnt
                while graph[r][c]:
                    mass, speed, direction = graph[r][c].pop(0)
                    total_mass += mass
                    total_speed += speed
                    if direction % 2 == 0:
                        even_dir += 1
                    else:
                        odd_dir += 1
                if even_dir == fb_cnt or odd_dir == fb_cnt:
                    nd = [0, 2, 4, 6]
                else:
                    nd = [1, 3, 5, 7]
                if total_mass // 5:
                    for d in nd:
                        Fireball.append([r, c, total_mass // 5, total_speed // fb_cnt, d])
            elif fb_cnt == 1:
                Fireball.append([r, c] + graph[r][c].pop())

print(sum([f[2] for f in Fireball]))