def solution(dirs):
    
    mapper = { 'U': 0, 'D': 1, 'L': 2, 'R': 3 }
    
    dr = [-1, 1, 0, 0]
    dc = [0, 0, -1, 1]
    
    sr, sc = 5, 5
    
    edges = set()
    
    for d in dirs:
        idx = mapper[d]
        nr = sr + dr[idx]
        nc = sc + dc[idx]
        if 0 <= nr <= 10 and 0 <= nc <= 10:
            coord1 = (sr, sc)
            coord2 = (nr, nc)
            
            if coord1 > coord2:
                tmp = coord2
                coord2 = coord1
                coord1 = tmp
            
            edge = (coord1, coord2)
            edges.add(edge)
            
            sr = nr
            sc = nc
    
    return len(edges)