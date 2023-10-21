def solution(topping):
    answer = 0
    
    counter1, counter2 = {}, {}
    
    for t in topping:
        if t in counter1:
            counter1[t] += 1
        else:
            counter1[t] = 1
    
    N = len(topping)
    
    for i in range(N):
        top = topping[i]
        
        counter1[top] -= 1
    
        if counter1[top] == 0:
            counter1.pop(top)
        
        if top in counter2:
            counter2[top] += 1
        else:
            counter2[top] = 1
        
        
        if len(counter1) == len(counter2):
            answer += 1
    
    return answer