def gcd(a, b):
    if b == 0:
        return a
    return gcd(b, a % b)


def solution(arrayA, arrayB):
    answer = 0
    
    N = len(arrayA)
    
    gcd_a = arrayA[0]
    
    for i in range(1, N):
        gcd_a = gcd(gcd_a, arrayA[i])
    
    cannot_div_b = True
    
    for i in range(N):
        if arrayB[i] % gcd_a == 0:
            cannot_div_b = False
            break
    
    gcd_b = arrayB[0]
    
    for i in range(1, N):
        gcd_b = gcd(gcd_b, arrayB[i])
        
    cannot_div_a = True
    
    for i in range(N):
        if arrayA[i] % gcd_b == 0:
            cannot_div_a = False
            break
    
    
    if not cannot_div_b and not cannot_div_a:
        return 0
    elif not cannot_div_b and cannot_div_a:
        return gcd_b
    elif cannot_div_b and not cannot_div_a:
        return gcd_a
    elif cannot_div_b and cannot_div_a:
        return max(gcd_a, gcd_b)
    