import sys
import heapq
input = sys.stdin.readline
INF = sys.maxsize

V, E = map(int, input().split())
K = int(input())

graph = [[] for _ in range(V + 1)]

for _ in range(E):
    u, v, w = map(int, input().split())
    graph[u].append((w, v))

heap = []
dp = [INF] * (V + 1)


def Dijstra(start):

    heapq.heappush(heap, (0, start))

    while heap:
        w, node = heapq.heappop(heap)

        if dp[node] < w:
            continue

        for weight, next_node in graph[node]:
            next_weight = w + weight
            if dp[next_node] > next_weight:
                dp[next_node] = next_weight
                heapq.heappush(heap, (next_weight, next_node))


dp[K] = 0
Dijstra(K)
for i in range(1, V + 1):
    if dp[i] == INF:
        print("INF")
    else:
        print(dp[i])