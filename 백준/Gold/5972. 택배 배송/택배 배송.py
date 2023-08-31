import sys
import heapq
INF = sys.maxsize
N, M = map(int, input().split())
edges = [[] for _ in range(N+1)]

for _ in range(M):
    a, b, c = map(int, input().split())
    edges[a].append((c, b))
    edges[b].append((c, a))


def dijkstra(start):
    queue = []
    heapq.heappush(queue, (0, start))
    dist = [INF] * (N + 1)
    dist[start] = 0
    while queue:
        cost, node = heapq.heappop(queue)
        if dist[node] < cost:
            continue
        for next_cost, next_node in edges[node]:
            if cost + next_cost < dist[next_node]:
                dist[next_node] = cost + next_cost
                heapq.heappush(queue, (dist[next_node], next_node))

    return dist[N]


print(dijkstra(1))