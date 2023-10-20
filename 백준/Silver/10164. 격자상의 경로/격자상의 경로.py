N, M, K = map(int, input().split())

mat = [[0] * (M + 1) for _ in range(N + 1)]

row, col = N, K
mat[1][1] = 1

if K > 0:
    row = (K // M) + 1
    col = (K % M)

    for r in range(1, row + 1):
        for c in range(1, col + 1):
            if (r, c) == (1, 1):
                continue
            mat[r][c] = mat[r-1][c] + mat[r][c-1]

    for r in range(row, N + 1):
        for c in range(col, M + 1):
            if (r, c) == (row, col):
                continue
            mat[r][c] = mat[r-1][c] + mat[r][c-1]
else:
    for r in range(1, N + 1):
        for c in range(1, M + 1):
            if (r, c) == (1, 1):
                continue
            mat[r][c] = mat[r-1][c] + mat[r][c-1]

print(mat[N][M])