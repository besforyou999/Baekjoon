N, M = map(int, input().split())
matrix = [[0] * (N + 1) for _ in range(N + 1)]

for _ in range(M):
    a, b = map(int, input().split())
    matrix[a][b] = 1

for k in range(1, N + 1):
    for i in range(1, N + 1):
        for j in range(1, N + 1):
            if matrix[i][k] == 1 and matrix[k][j] == 1:
                matrix[i][j] = 1

count1, count2, answer = 0, 0, 0
weight = (N + 1) // 2

for i in range(1, N + 1):
    count1, count2 = 0, 0
    for j in range(1, N + 1):
        if i == j:
            continue

        if matrix[i][j] == 1:
            count1 += 1

        if matrix[j][i] == 1:
            count2 += 1

    if count1 >= weight or count2 >= weight:
        answer += 1

print(answer)