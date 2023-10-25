import heapq

def solution(N, road, K):

    INF = int(1e10)
    distance = [INF] * (N + 1)
    
    graph = [[] for _ in range(N + 1)]
    
    for a, b, c in road:
        graph[a].append((c, b))
        graph[b].append((c, a))
    
    queue = []
    heapq.heappush(queue, (0, 1))
    distance[1] = 0
    
    while queue:
        cost, node = heapq.heappop(queue)
        
        if distance[node] < cost:
            continue
        
        distance[node] = cost
        
        for ncost, nnode in graph[node]:
            if distance[nnode] > ncost + cost:
                distance[nnode] = ncost + cost
                heapq.heappush(queue, (ncost + cost, nnode))
    
    answer = 0
    
    for i in range(1, N + 1):
        if distance[i] <= K:
            answer += 1
        
    return answer