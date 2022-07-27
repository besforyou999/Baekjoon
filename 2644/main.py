from collections import deque

n = int(input())

graph = [[] for _ in range(n+1)]
visited = [False for _ in range(n+1)]

first, second = map(int, input().split(' '))

m = int(input())

for i in range(m):
    parent, child = map(int, input().split(' '))
    graph[parent].append(child)
    graph[child].append(parent)

q = deque()
q.append((0, first))

def bfs():
    while q:
        depth, node = q.popleft()
        visited[node] = True
        for i in graph[node]:
            if not visited[i]:
                if i == second:
                    return depth + 1
                q.append((depth + 1, i))
    return -1

print(bfs())

