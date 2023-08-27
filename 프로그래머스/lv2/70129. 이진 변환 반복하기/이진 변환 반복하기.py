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
    zeroCnt = 0
    loop = 0

    while s != '1':
        tmp, deletedZero = step1(s)
        zeroCnt += deletedZero
        loop += 1
        s = bin(len(tmp))[2:]

    return [loop, zeroCnt]
