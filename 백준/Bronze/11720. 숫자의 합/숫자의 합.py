import sys
input = sys.stdin.readline

N = int(input())
number = input().rstrip()
sum = 0

for i in number:
    sum += int(i)

print(sum)
