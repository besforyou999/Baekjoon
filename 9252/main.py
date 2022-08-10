import sys
input = sys.stdin.readline

string1 = input()
string2 = input()

len1 = len(string1)
len2 = len(string2)

graph = [[0 for _ in range(len2)] for _ in range(len1)]


for i in range(1, len1):
    for j in range(1, len2):
        if string1[i-1] == string2[j-1]:
            graph[i][j] = graph[i-1][j-1] + 1
        else:
            graph[i][j] = max(graph[i-1][j], graph[i][j-1])

max_len = graph[len1 - 1][len2 - 1]
print(max_len)

answer = []
x = len2 - 1
y = len1 - 1
while x > 0 and y > 0:
    if graph[y][x-1] == graph[y][x]:
        x -= 1
    elif graph[y-1][x] == graph[y][x]:
        y -= 1
    else:
        answer.append(string1[y-1])
        x -= 1
        y -= 1

for ch in answer[::-1]:
    print(ch, end='')

