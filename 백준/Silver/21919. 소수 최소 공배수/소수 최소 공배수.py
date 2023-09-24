import sys
input = sys.stdin.readline

N = int(input())
Ai = list(map(int, input().split()))

N = 1000000
MAX = int(N**0.5)
isprime = [True] * N
isprime[0] = isprime[1] = False

for i in range(2, MAX + 1):
    if isprime[i]:
        for j in range(i + i, N, i):
            isprime[j] = False

multi = 1
used = set()
for a in Ai:
    if isprime[a] and a not in used:
        multi *= a
        used.add(a)

if multi == 1:
    multi = -1

print(multi)