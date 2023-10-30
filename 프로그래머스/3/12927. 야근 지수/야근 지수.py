from heapq import heappush, heappop


def solution(n, works):
    answer = 0
    
    queue = []
    
    for work in works:
        heappush(queue, (-work, work))
    
    for _ in range(n):
        if not queue:
            break
        
        pri, val = heappop(queue)
        
        if val - 1 > 0:
            heappush(queue, (-(val - 1), val - 1))
    
    for ele in queue:
        answer += ele[1] * ele[1]
    
    return answer