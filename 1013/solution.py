import sys
import re
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    line = input().rstrip()
    p = re.compile('(100+1+|01)+')
    if p.fullmatch(line):
        print("YES")
    else:
        print("NO")

