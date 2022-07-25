from collections import deque

# read N, M, V
N, M, V = map(int, input().split())
mat = [[0 for col in range(N+1)] for row in range(N+1)]
visited = [0 for col in range(N+1)]

# read start, end nodes
for row in range(M):
    start, end = map(int, input().split())
    mat[start][end] = mat[end][start] = 1

# dfs
def dfs(v):
   visited[v] = 1
   print(v, end=' ')
   for idx in range(1, N+1):
       if mat[v][idx] == 1 and visited[idx] == 0:
           dfs(idx)

#BFS
def bfs(start_v):
    discovered = [start_v]

    queue = deque()
    queue.append(start_v)

    while queue:
        v = queue.popleft()
        print(v, end=' ')

        for w in range(1 , N+1):
            if mat[v][w] == 1 and (w not in discovered):
                discovered.append(w)
                queue.append(w)


dfs(V)
print()
bfs(V)


