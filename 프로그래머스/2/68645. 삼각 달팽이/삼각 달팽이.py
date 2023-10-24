def solution(n):
    answer = []
    
    # 오른쪽 하단, 위, 좌
    dr = [1, -1, 0]
    dc = [1, 0, -1]
    
    matrix = [[0] * n for _ in range(n)]
    
    r, c, d, number = -1, -1, 0, 1
    
    for i in range(n, 0, -1):
        for _ in range(i):
            r = r + dr[d]
            c = c + dc[d]
            matrix[r][c] = number
            number += 1
        
        d += 1
        if d == 3:
            d = 0
            
    
    for c in range(n):
        for r in range(c, -1, -1):
            answer.append(matrix[r][c])
    
    return answer