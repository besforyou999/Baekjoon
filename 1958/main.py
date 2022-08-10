import sys
input = sys.stdin.readline

string1 = input().rstrip()
string2 = input().rstrip()
string3 = input().rstrip()

len1 = len(string1)
len2 = len(string2)
len3 = len(string3)

graph = [[[0 for _ in range(len3+1)] for _ in range(len2+1)] for _ in range(len1+1)]


for i in range(1, len1 + 1):
    for j in range(1, len2 + 1):
        for k in range(1, len3 + 1):
            if string1[i-1] == string2[j-1] == string3[k-1]:
                graph[i][j][k] = graph[i-1][j-1][k-1] + 1
            else:
                graph[i][j][k] = max(graph[i-1][j][k], graph[i][j-1][k], graph[i][j][k-1])

ans = 0

for i in range(1, len1 + 1):
    for j in range(1, len2 + 1):
        for k in range(1, len3 + 1):
            ans = max(ans, graph[i][j][k])

print(ans)
