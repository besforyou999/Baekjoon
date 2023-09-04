N = int(input())

A = list(map(int, input().split()))
B = list(map(int, input().split()))

A.sort()

tmp = 0

for i in range(N):
    a = A.pop(0)
    max_value = max(B)
    tmp += a * max_value
    B.remove(max_value)

print(tmp)