import sys
input = sys.stdin.readline

n = int(input())
Ai = list(map(int, input().split()))
lis = [0]

for a in Ai:
    if lis[-1] < a:
        lis.append(a)
    else:
        left = 0
        right = len(lis)
        while left < right:
            mid = (left + right) // 2
            if lis[mid] < a:
                left = mid + 1
            else:
                right = mid
        lis[right] = a

print(len(lis) - 1)

