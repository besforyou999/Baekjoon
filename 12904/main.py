import sys
input = sys.stdin.readline

S = input().rstrip()
T = input().rstrip()
len1 = len(S)
len2 = len(T)


def flip_str(string):
    buffer = ""
    length = len(string)
    for i in range(length):
        buffer += string[length - i - 1]
    return buffer


while len(T) > 1 and len(T) > len(S):
    last_idx = len(T) - 1
    ch = T[last_idx]
    buffer = ""
    if ch == 'A':
        buffer = T[0:last_idx]
    elif ch == 'B':
        buffer = T[0:last_idx]
        buffer = flip_str(buffer)
    T = buffer

    if T == S:
        print(1)
        sys.exit(0)

print(0)

