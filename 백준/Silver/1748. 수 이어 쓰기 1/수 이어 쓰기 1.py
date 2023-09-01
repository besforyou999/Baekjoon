N = input().rstrip()

length = len(N)

ans = 0

for i in range(1, length):
    ans += i * 9 * pow(10, i - 1)

N = int(N)
lower = pow(10, length - 1)

ans += (N - lower + 1) * length

print(ans)