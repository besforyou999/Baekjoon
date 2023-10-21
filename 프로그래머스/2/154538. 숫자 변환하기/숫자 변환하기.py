from collections import deque


def solution(x, y, n):
    answer = -1
    
    if x == y:
        return 0
    
    x_set = set()
    
    queue = deque()
    queue.append((x, 0))
    x_set.add(x)
    
    while queue:
        num, cnt = queue.popleft()
        plus = num + n
        if plus not in x_set:
            if plus == y:
                answer = cnt + 1
                break
            elif plus > y:
                continue
            else:
                x_set.add(plus)
                queue.append((plus, cnt + 1))

        multi2 = num * 2
        if multi2 not in x_set:
            if multi2 == y:
                answer = cnt + 1
                break
            elif multi2 > y:
                continue
            else:
                x_set.add(multi2)
                queue.append((multi2, cnt + 1))

        multi3 = num * 3
        if multi3 not in x_set:
            if multi3 == y:
                answer = cnt + 1
                break
            elif multi3 > y:
                continue
            else:
                x_set.add(multi3)
                queue.append((multi3, cnt + 1))

    return answer