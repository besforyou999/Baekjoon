import copy


def getMax(arr):
    N = len(arr)
    dp = [0] * N
    
    dp[0] = arr[0]
    dp[1] = max(dp[0], arr[1])
    
    for i in range(2, N):
        dp[i] = max(dp[i-2] + arr[i], dp[i-1])
    
    return max(dp)


def solution(sticker):
    
    N = len(sticker)
    
    if N <= 2:
        return max(sticker)

    sticker1 = copy.deepcopy(sticker)
    sticker1[-1] = 0
    
    sticker2 = copy.deepcopy(sticker)
    sticker2[0] = 0

    return max(getMax(sticker1), getMax(sticker2))