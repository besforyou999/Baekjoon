from collections import deque


def bfs(start, n, graph):
    visit = [False] * (n + 1)
    visit[start] = True
    
    queue = deque()
    queue.append(start)
    result = 0
    
    while queue:
        node = queue.popleft()
        result += 1
        
        for next_node in graph[node]:
            if not visit[next_node]:
                visit[next_node] = True
                queue.append(next_node)
    
    return result


def solution(n, wires):
    answer = int(1e10)
    
    graph = [[] for _ in range(n + 1)]
    
    for s, e in wires:
        graph[s].append(e)
        graph[e].append(s)
    
    for s, e in wires:
        graph[s].remove(e)
        graph[e].remove(s)
        
        
        one = bfs(s, n, graph)
        two = bfs(e, n, graph)
        
        diff = abs(bfs(s, n, graph) - bfs(e, n, graph))
        answer = min(answer, diff)
        
        graph[s].append(e)
        graph[e].append(s)
        
    return answer