def solution(board):
    
    N = len(board)
    M = len(board[0])
    
    if N == 1 or M == 1:
        size = 0
        for r in range(N):
            for c in range(M):
                size = max(size, board[r][c])
        
        return size
    
    dp = [[0] * (M + 1) for _ in range(N + 1)]
    
    size = 0
    
    for r in range(1, N + 1):
        for c in range(1, M + 1):
            if board[r-1][c-1] == 1:
                val = min(dp[r-1][c-1], dp[r][c-1], dp[r-1][c])
                dp[r][c] = val + 1
                size = max(size, dp[r][c])
                
    
    return size * size