def solution(s):
    s = s[1: -1]

    tokens = []
    token = []
    tmp = ''
    inToken = False

    for i in range(len(s)):
        if s[i] == '{':
            token = []
            tmp = ''
            inToken = True
        elif '0' <= s[i] <= '9' and inToken:
            tmp += s[i]
        elif s[i] == ',' and inToken:
            token.append(int(tmp))
            tmp = ''
        elif s[i] == '}':
            if len(tmp) > 0:
                token.append(int(tmp))
            tokens.append(token)
            tmp = ''
            token = []
            inToken = False

    tokens.sort(key=lambda e: len(e))
    answer = []

    for token in tokens:
        for ele in token:
            if ele not in answer:
                answer.append(ele)

    return answer
