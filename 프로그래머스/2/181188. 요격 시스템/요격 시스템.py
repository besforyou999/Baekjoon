def solution(targets):

    targets.sort(key=lambda x: (x[0]))
    size = len(targets)
    
    answer = 0
    bound = 0
    
    for i in range(size):
        start, end = targets[i]
        if start < bound:
            bound = min(bound, end)
        else:
            answer += 1
            bound = end
    
    return answer