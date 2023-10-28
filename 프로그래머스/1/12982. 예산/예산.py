def solution(money, budget):
    answer = 0
    
    money.sort()
    
    for d in money:
        if d > budget:
            break
        else:
            budget -= d
            answer += 1
    
    return answer