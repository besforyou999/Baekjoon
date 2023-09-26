import sys, heapq
input = sys.stdin.readline
INF = int(1e10)

n, m = map(int, input().split())
dist = [INF] * (n + 1)
graph = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((c, b))
    graph[b].append((c, a))

s, t = map(int, input().split())


def dijkstra(start):
    q = []
    dist[start] = 0

    heapq.heappush(q, (0, start))

    while q:
        cost, num = heapq.heappop(q)

        if dist[num] < cost:
            continue

        for n_cost, n_num in graph[num]:
            new_edge_w = cost + n_cost
            if dist[n_num] > new_edge_w:
                dist[n_num] = new_edge_w
                heapq.heappush(q, (new_edge_w, n_num))


dijkstra(s)
print(dist[t])