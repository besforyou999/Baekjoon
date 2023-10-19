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

    
    return False if stack else True


def solution(s):
    
    answer = 0
    size = len(s)

    for x in range(size):
        if check_correct(s[x:] + s[:x]):
            answer += 1

    return answer