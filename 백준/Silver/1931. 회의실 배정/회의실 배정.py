import sys
input = sys.stdin.readline

N = int(input())

elements = []
for _ in range(N):
    start, end = map(int, input().split())
    elements.append((start, end))

elements.sort(key=lambda e: (e[1], e[0]))

first = elements.pop(0)
ans = [first]
cur = first[1]

for ele in elements:
    if cur <= ele[0]:
        ans.append(ele)
        cur = ele[1]

print(len(ans))