import sys
input = sys.stdin.readline

N, M, B = map(int, input().split())

graph = []

for _ in range(N):
    graph.append(list(map(int, input().split())))

min_time = sys.maxsize
answer_h = 0

min_height, max_height = 260, -1

for r in range(N):
    for c in range(M):
        min_height = min(min_height, graph[r][c])
        max_height = max(max_height, graph[r][c])

for height in range(max_height, min_height - 1, -1):
    block_needed, remove_block = 0, 0
    for r in range(N):
        for c in range(M):
            block = graph[r][c]
            if block <= height:
                block_needed += height - block
            else:
                remove_block += block - height

    if block_needed > remove_block + B:
        continue

    time = block_needed + remove_block * 2
    if time < min_time:
        min_time = time
        answer_h = height

print(min_time, answer_h)