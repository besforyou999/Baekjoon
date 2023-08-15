import sys
input = sys.stdin.readline

line1 = input().rstrip()
line2 = input().rstrip()

len1 = len(line1)
len2 = len(line2)

graph = [[0 for _ in range(len2 + 1)] for _ in range(len1 + 1)]

for i in range(1, len1 + 1):
    for j in range(1, len2 + 1):
        if line1[i - 1] == line2[j - 1]:
            graph[i][j] = graph[i-1][j-1] + 1
        else:
            graph[i][j] = max(graph[i-1][j], graph[i][j-1])

answer = -1

for i in range(1, len1 + 1):
    for j in range(1, len2 + 1):
        answer = max(answer, graph[i][j])

print(answer)