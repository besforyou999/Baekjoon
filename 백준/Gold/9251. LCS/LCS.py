line1 = input()
line2 = input()

N1 = len(line1)
N2 = len(line2)

graph = [[0] * (N2 + 1) for _ in range(N1 + 1)]

for i in range(1, N1 + 1):
    for j in range(1, N2 + 1):
        if line1[i-1] == line2[j-1]:
            graph[i][j] = graph[i-1][j-1] + 1
        else:
            graph[i][j] = max(graph[i-1][j], graph[i][j-1])

print(graph[N1][N2])