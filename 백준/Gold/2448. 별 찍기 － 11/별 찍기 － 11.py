N = int(input())

graph = [[' '] * (2 * N) for _ in range(N)]


def rec(r, c, n):
    if n == 3:
        graph[r][c] = '*'
        graph[r + 1][c - 1] = graph[r + 1][c + 1] = '*'
        graph[r + 2][c - 2] = graph[r + 2][c - 1] = graph[r + 2][c] = graph[r + 2][c + 1] = graph[r + 2][c + 2] = '*'
        return
    else:
        half = n // 2
        rec(r, c, half)
        rec(r + half, c + half, half)
        rec(r + half, c - half, half)


rec(0, N - 1, N)

for r in graph:
    print("".join(r))