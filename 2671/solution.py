import re
import sys
input = sys.stdin.readline

line = input().rstrip()
pattern = re.compile('(100+1+|01)+')
if pattern.fullmatch(line):
    print("SUBMARINE")
else:
    print("NOISE")

