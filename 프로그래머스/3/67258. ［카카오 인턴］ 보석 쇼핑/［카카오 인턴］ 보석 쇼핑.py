from collections import Counter


def solution(gems):
    answer = []
    
    gemCount = Counter(gems)
    totalTypes = len(gemCount)

    bucket = {}
    types = 0
    
    lp, rp = (0, 0)
    
    candidates = []
    
    while rp < len(gems):
        gem = gems[rp]
        
        if gem in bucket:
            bucket[gem] += 1
        else:
            types += 1
            bucket[gem] = 1
        
        while types == totalTypes and lp < len(gems):
            candidates.append((lp + 1, rp + 1))
            gem2 = gems[lp]
            bucket[gem2] -= 1
            lp += 1
            if bucket[gem2] == 0:
                del bucket[gem2]
                types -= 1
        
        rp += 1
        
    candidates.sort(key = lambda x: (abs(x[0] - x[1]), x[0]))
    
    l, r = candidates[0]
    
    return [l, r]