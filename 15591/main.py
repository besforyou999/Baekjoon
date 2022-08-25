import sys
from collections import deque, defaultdict


def find(start_n, k, graph):
    queue = deque()
    queue.append((start_n, float('inf')))
    visited = [-1] * N
    visited[start_n] = 1
    count = 0

    while queue:
        pop_node, min_dist = queue.popleft()
        for next_n, dist in graph[pop_node]:
            if visited[next_n] == 1:
                continue
            if min_dist > dist:
                queue.append((next_n, dist))
                if dist >= k:
                    count += 1
            else:
                queue.append((next_n, min_dist))
                if min_dist >= k:
                    count += 1
            visited[next_n] = 1

    return count


N, Q = map(int, sys.stdin.readline().split())
graph = defaultdict(list)

for _ in range(N-1):
    pi, qi, ri = map(int, sys.stdin.readline().split())
    graph[pi - 1].append((qi - 1, ri))
    graph[qi - 1].append((pi - 1, ri))

for _ in range(Q):
    k, vi = map(int, sys.stdin.readline().split())
    print(find(vi - 1, k, graph))


