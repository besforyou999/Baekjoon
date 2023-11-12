from collections import deque


def dijkstra(start, distance, graph):
    
    queue = deque()
    queue.append((start, 0))
    distance[start] = 0
    
    while queue:
        n, cost = queue.popleft()
        
        if distance[n] < cost:
            continue
        
        for dest in graph[n]:
            if cost + 1 < distance[dest]:
                distance[dest] = cost + 1
                queue.append((dest, cost + 1))
            

def solution(n, edges):
    answer = 0
    
    INF = int(1e10)
    distance = [INF] * (n + 1)
    
    graph = [[] for _ in range(n + 1)]
    
    for s, d in edges:
        graph[s].append(d)
        graph[d].append(s)
    
    dijkstra(1, distance, graph)
    
    
    most_far = max(distance[1:])
    
    for d in distance:
        if d == most_far:
            answer += 1
    
    return answer