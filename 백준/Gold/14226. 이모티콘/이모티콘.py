import sys

S = int(input())
from collections import deque

queue = deque()
queue.append((1, 0))
dp = [[-1] * (S + 1) for _ in range(S + 1)]
dp[1][0] = 0

while queue:
    s, c = queue.popleft()
    if dp[s][s] == -1:
        dp[s][s] = dp[s][c] + 1
        queue.append((s, s))
    if s + c <= S and dp[s + c][c] == -1:
        dp[s + c][c] = dp[s][c] + 1
        queue.append((s + c, c))
    if s - 1 >= 0 and dp[s - 1][c] == -1:
        dp[s - 1][c] = dp[s][c] + 1
        queue.append((s - 1, c))

answer = sys.maxsize

for i in range(S + 1):
    if dp[S][i] != -1 and answer > dp[S][i]:
        answer = dp[S][i]

print(answer)