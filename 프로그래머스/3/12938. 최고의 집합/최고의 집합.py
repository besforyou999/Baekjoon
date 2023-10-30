def solution(n, s):
    
    if n > s:
        return [-1]
    
    if n == s:
        return [1] * n
    
    div = s // n
    
    answer = [div] * n
    
    s -= div * n
    
    for i in range(n):
        if s == 0:
            break
        answer[i] += 1
        s -= 1
    
    answer.sort()
        
    return answer