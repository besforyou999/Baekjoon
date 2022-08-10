import sys
input = sys.stdin.readline

string1 = input().rstrip()
string2 = input().rstrip()

len1 = len(string1)
len2 = len(string2)

graph = [[0 for _ in range(len2+1)] for _ in range(len1+1)]


for i in range(1, len1 + 1):
    for j in range(1, len2 + 1):
        if string1[i-1] == string2[j-1]:
            graph[i][j] = graph[i-1][j-1] + 1
        else:
            graph[i][j] = max(graph[i-1][j], graph[i][j-1])

ans = 0

for i in range(1, len1 + 1):
    for j in range(1, len2 + 1):
        ans = max(ans, graph[i][j])

print(ans)

