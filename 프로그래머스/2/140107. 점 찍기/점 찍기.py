import math


def getX(y, d):
    return math.sqrt(d*d - y*y)


def solution(k, d):
    answer = 0
    
    for y in range(0, d + 1, k):
        x = getX(y, d)
        answer += (x // k) + 1
    
    return answer