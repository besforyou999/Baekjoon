import sys

a = 'AAAA'
b = 'BB'

line = input()
answer = ''
tmp = ''


def convert(board):
    size = len(board)
    if size % 2 == 1 or size <= 1:
        return False

    a_cnt = size // 4
    size %= 4
    b_cnt = size // 2

    return a * a_cnt + b * b_cnt


for ch in line:
    if ch == '.':
        if tmp == '':
            answer += ch
        else:
            result = convert(tmp)
            if not result:
                print(-1)
                sys.exit(0)
            tmp = ''
            answer += result + ch
    else:
        tmp += ch

if tmp:
    result = convert(tmp)
    if not result:
        print(-1)
        sys.exit(0)
    answer += result

print(answer)