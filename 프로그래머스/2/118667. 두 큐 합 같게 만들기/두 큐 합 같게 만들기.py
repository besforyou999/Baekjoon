from collections import deque

def solution(queue1, queue2):
    
    queue1 = deque(queue1)
    queue2 = deque(queue2)
    q1 = sum(queue1)
    q2 = sum(queue2)
    
    if q1 == q2:
        return 0
    
    turn = 0
    
    max_len = max(len(queue1), len(queue2))
    
    for m in range(4 * max_len):
        # print("turn : ", m)
        # print(*queue1)
        # print(*queue2)
        
        if q1 < q2:
            front = queue2.popleft()
            q2 -= front
            
            queue1.append(front)
            q1 += front
        elif q1 > q2:
            front = queue1.popleft()
            q1 -= front
            
            queue2.append(front)
            q2 += front
        else:
            break
        
        turn += 1
    
    
    if turn == 4 * max_len:
        turn = -1
    
    return turn