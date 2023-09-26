import sys,heapq
input = sys.stdin.readline
INF = int(1e10)

N, M = map(int, input().split())
visible = list(map(int, input().split())) # 0 이면 안보임, 1이면 보인다는 뜻
visible[-1] = 0
graph = [[] for _ in range(N)]
for _ in range(M):
    a, b, t = map(int, input().split())
    graph[a].append((t, b))
    graph[b].append((t, a))

dist = [INF] * N


def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    dist[start] = 0

    while q:
        cost, num = heapq.heappop(q) # 지금까지 탐색하며 누적된 거리, 탐색할 정점 숫자

        if dist[num] < cost: # 시작점에서 탐색할 정점 사이 거리가 지금까지 누적된 거리보다 작다면 탐색 X
            continue

        for n_cost, n_num in graph[num]:
            weight = cost + n_cost
            if dist[n_num] > weight and visible[n_num] == 0:
                dist[n_num] = weight
                heapq.heappush(q, (weight, n_num))


dijkstra(0)
print(dist[N-1] if dist[N - 1] != INF else -1)