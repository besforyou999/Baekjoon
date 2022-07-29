from sys import stdin

n = int(stdin.readline())
ans = 0
num_str = stdin.readline()

for i in range(n):
    ans += int(num_str[i])

print(ans)
