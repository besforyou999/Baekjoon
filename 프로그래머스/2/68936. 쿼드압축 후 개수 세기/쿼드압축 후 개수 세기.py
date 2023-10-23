def rec(arr, r, c, size):
    all_same = True
    number = arr[r][c]
    for y in range(r, r + size):
        for x in range(c, c + size):
            if arr[y][x] != number:
                all_same = False
                break
        
        if not all_same:
            break
    
    if all_same:
        return str(number)
    
    half = size // 2
    
    return rec(arr, r, c, half) + rec(arr, r, c + half, half) + rec(arr, r + half, c, half) + rec(arr, r + half, c + half, half)



def solution(arr):
    answer = [0, 0]
    
    result = rec(arr, 0, 0, len(arr))
    print(result)
    for i in result:
        answer[int(i)] += 1

    return answer