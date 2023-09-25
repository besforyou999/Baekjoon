import sys
input = sys.stdin.readline

N, M = map(int, input().split())
A = set(map(int, input().split()))
B = set(map(int, input().split()))

cnt_a, cnt_b = 0, 0

for a in A:
    if a not in B:
        cnt_a += 1

for b in B:
    if b not in A:
        cnt_b += 1

print(cnt_a + cnt_b)