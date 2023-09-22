import sys
input = sys.stdin.readline

N = int(input())
lengths = []
for _ in range(N):
    lengths.append(int(input()))

lengths.sort(reverse=True)
ans = -1
for i in range(N - 2):
    one = lengths[i]
    two = lengths[i + 1]
    three = lengths[i + 2]
    if one < two + three:
        ans = one + two + three
        break

print(ans)