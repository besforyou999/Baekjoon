def solution(n, left, right):
    answer = []
    
    pos1 = ((left // n) + 1, (left % n) + 1)
    pos2 = ((right // n) + 1, (right % n) + 1)
    
    for row in range(pos1[0], pos2[0] + 1):
        for col in range(1, n + 1):
            if col < row:
                answer.append(row)
            else:
                answer.append(col)
                
    pop_cnt = n - pos2[1]
    answer = answer[pos1[1] - 1:]
    
    for _ in range(pop_cnt):
        answer.pop()
    
    
    return answer