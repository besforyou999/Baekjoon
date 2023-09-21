N = int(input())
graph = [list(input().split()) for _ in range(N)]

# 아래, 오른쪽
dr = [1, 0]
dc = [0, 1]

small = int(1e10)
big = -int(1e10)


def dfs(r, c, rec):
    if r == N - 1 and c == N - 1:
        tmp = rec[0]
        for i in range(1, N):
            front = tmp
            mid = str(rec[i * 2 - 1])
            back = str(rec[i * 2])
            tmp = str(eval(front + mid + back))

        result = int(tmp)
        global small, big
        small = min(small, result)
        big = max(big, result)
        return

    for i in range(2):
        nr = r + dr[i]
        nc = c + dc[i]
        if 0 <= nr < N and 0 <= nc < N:
            dfs(nr, nc, rec + graph[nr][nc])


dfs(0, 0, graph[0][0])
print(big, small)