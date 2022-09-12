import sys
input = sys.stdin.readline


# kmp table
def make_table(pattern):
    table = [0 for _ in range(len(pattern))]
    i = 0
    for j in range(1, len(pattern)):
        while i > 0 and pattern[i] != pattern[j]:
            i = table[i-1]
        if pattern[i] == pattern[j]:
            i += 1
            table[j] = i
    return max(table)


line = input().rstrip()
ans = 0

for idx in range(len(line)):
    sub_str = line[0:len(line) - idx]
    ans = max(ans, make_table(sub_str))

print(ans)

