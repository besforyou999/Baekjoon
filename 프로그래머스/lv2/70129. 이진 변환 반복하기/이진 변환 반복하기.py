def step1(s):
    cnt = 0
    tmp = ''
    for i in s:
        if i == '1':
            tmp += '1'
        else:
            cnt += 1
    return [tmp, cnt]


def solution(s):
    zero_cnt = 0
    loop = 0

    while s != '1':
        loop += 1
        num = s.count('1')
        zero_cnt += len(s) - num
        s = bin(num)[2:]
        
    return [loop, zero_cnt]
