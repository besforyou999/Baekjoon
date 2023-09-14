cost = 1000 - int(input())

money = [500, 100, 50, 10, 5, 1]

cnt = 0

for m in money:
    if cost >= m:
        cnt += int(cost // m)
        cost %= m

print(cnt)