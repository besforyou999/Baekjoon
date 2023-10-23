from collections import deque


def solution(order):
    answer = 0
    N = len(order)
    
    semi_belt = []
    belt = deque([i for i in range(1, N + 1)])
    
    for o in order:
        # 보조 벨트 먼저 확인
        if semi_belt:
            if semi_belt[-1] == o:
                semi_belt.pop()
                answer += 1
                continue
        
        # 메인 벨트에 있는지 확인
        found = False
        while belt:
            num = belt.popleft()
            if num == o:
                found = True
                answer += 1
                break
            else:
                semi_belt.append(num)

        if not found:
            break
    
    return answer