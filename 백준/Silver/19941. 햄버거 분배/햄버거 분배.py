import sys

input = sys.stdin.readline

N, K = map(int, input().split())
arr = list(input())
used = [False] * (N + 1)

ans = 0

for i in range(N):
    if arr[i] == 'P':
        # 선택 가능한 후보 모두 찾은 다음 가장 왼쪽을 선택
        pt = i - K
        found = False
        for j in range((2*K) + 1):
            if found:
                break
            if 0 <= pt + j < N and not used[pt + j] and arr[pt + j] == 'H':
                used[pt + j] = True
                found = True
                ans += 1

print(ans)