def solution(land):
    
    N = len(land)
    dp = [[0] * 4 for _ in range(N)]
    
    for i in range(4):
        dp[0][i] = land[0][i]
    
    for r in range(1, N):
        for c in range(4):
            max_val = -1
            for j in range(4):
                if c == j:
                    continue
                max_val = max(max_val, dp[r-1][j])
        
            dp[r][c] = land[r][c] + max_val
    
    answer = -1
    
    for c in range(4):
        answer = max(answer, dp[N - 1][c])
        

    return answer