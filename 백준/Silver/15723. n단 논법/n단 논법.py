n = int(input())
graph = [[0] * (27) for _ in range(27)]

for _ in range(n):
    a, text, b = input().split(" ")
    a = ord(a) - 96
    b = ord(b) - 96
    graph[a][b] = 1

for k in range(1, 27):
    for i in range(1, 27):
        for j in range(1, 27):
            if graph[i][k] == 1 and graph[k][j] == 1:
                graph[i][j] = 1

c = int(input())
for _ in range(c):
    a, text, b = input().split(" ")
    a = ord(a) - 96
    b = ord(b) - 96
    if graph[a][b] == 1:
        print("T")
    else:
        print("F")