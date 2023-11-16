import copy


def dfs(start, route, N, tickets, used, answer):
    if N + 1 == len(route):
        answer.append(copy.deepcopy(route))
        return
    
    for i in range(N):
        if not used[i] and tickets[i][0] == start:
            s, end = tickets[i]
            used[i] = True
            route.append(end)
            dfs(end, route, N, tickets, used, answer)
            route.pop()
            used[i] = False
            

def solution(tickets):
    
    N = len(tickets)
    
    used = [False] * N
    
    tickets.sort(key=lambda x: (x[0], x[1]))
    
    route = ["ICN"]
    
    answer = []
    
    dfs("ICN", route, N, tickets, used, answer)
    
    return answer[0]

