def check_valid(s):
    one, two, three = 0, 0, 0

    for ch in s:
        if ch == '[':
            one += 1
        elif ch == ']':
            one -= 1
        elif ch == '(':
            two += 1
        elif ch == ')':
            two -= 1
        elif ch == '{':
            three += 1
        else:
            three -= 1

    if (one, two, three) == (0, 0, 0):
        return True

    return False


def check_correct(s):
    stack = []

    for ch in s:
        if ch == '[':
            stack.append(ch)
        elif ch == ']':
            if not stack or stack[-1] != '[':
                return False
            else:
                stack.pop()
        elif ch == '(':
            stack.append(ch)
        elif ch == ')':
            if not stack or stack[-1] != '(':
                return False
            else:
                stack.pop()
        elif ch == '{':
            stack.append(ch)
        elif ch == '}':
            if not stack or stack[-1] != '{':
                return False
            else:
                stack.pop()

    return True


def left_rotate(s):
    first = s[0]
    body = s[1:]
    return body + first


def solution(s):
    if not check_valid(s):
        return 0

    answer = 0
    size = len(s)

    for x in range(size):
        if check_correct(s):
            answer += 1
        s = left_rotate(s)

    return answer