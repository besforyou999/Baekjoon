from sys import stdin

line = stdin.readline()

stack = []
idx = 0
answer = ""

while True:
    ch = line[idx]
    if ch == '<':
        if len(stack) > 0:
            while len(stack) > 0:
                answer += stack.pop()
        while idx < len(line):
            letter = line[idx]
            answer += letter
            if letter == '>':
                break
            idx += 1
    elif ch == ' ':
        if len(stack) == 0:
            answer += ' '
            continue
        else:
            while len(stack) > 0:
                answer += stack.pop()
            answer += ' '
    elif ch == '\n':
        idx += 1
    else:
        stack.append(ch)
    idx += 1

    if idx >= len(line):
        if len(stack) > 0:
            while len(stack) > 0:
                temp = stack.pop()
                answer += temp
        break


print(answer)





