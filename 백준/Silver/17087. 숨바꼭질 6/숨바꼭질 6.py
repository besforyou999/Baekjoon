import sys
input = sys.stdin.readline

N, S = map(int, input().split())
Ai = list(map(int, input().split()))

diff = []

for i in Ai:
    diff.append(abs(S - i))


def gcd(a, b):
    if b == 0:
        return a
    return gcd(b, a % b)


for i in range(N - 1):
    a = diff[i]
    b = diff[i + 1]
    diff[i + 1] = gcd(a, b)

print(diff[-1])