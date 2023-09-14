N = int(input())
Pi = list(map(int, input().split()))

Pi.sort()

Pi.insert(0, 0)

for i in range(1, N + 1):
    Pi[i] = Pi[i] + Pi[i - 1]

print(sum(Pi))