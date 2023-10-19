def solution(n):
    answer = 0
    div = 1234567
    
    if n <= 3:
        return n
    
    dp = [0] * (n + 1)
    dp[1] = 1
    dp[2] = 2
    dp[3] = 3
    
    for i in range(4, n + 1):
        dp[i] = (dp[i-1] + dp[i-2]) % div
    
    return dp[n]