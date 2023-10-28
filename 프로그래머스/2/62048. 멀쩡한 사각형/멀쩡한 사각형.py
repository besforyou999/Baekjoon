def gcd(a, b):
    if b == 0:
        return a
    return gcd(b, a % b)


def solution(w,h):
    
    total = w * h
    div = gcd(w, h)
    
    row = h // div
    col = w // div
    
    cut = row * col - (row - 1) * (col - 1)

    return total - cut * div