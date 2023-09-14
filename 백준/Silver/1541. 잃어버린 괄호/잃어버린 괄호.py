import sys
input = sys.stdin.readline

tokens = input().strip().split("-")
result = []
for token in tokens:
    result.append(sum(list(map(int, token.split("+")))))

ans = result.pop(0)

for num in result:
    ans -= num

print(ans)