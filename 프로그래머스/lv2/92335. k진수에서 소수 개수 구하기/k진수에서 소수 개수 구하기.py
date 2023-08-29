import math


def convert(number, base):
    tmp = ''
    while number:
        tmp = str(number % base) + tmp
        number //= base
    return tmp


def isPrime(number):
    if number == 1:
        return False
    for i in range(2, int(math.sqrt(number) + 1)):
        if number % i == 0:
            return False
    return True


def solution(n, k):
    answer = 0

    number = convert(n, k)

    tmp = ''
    for i in number:
        if i == '0':
            if len(tmp) > 0:
                if isPrime(int(tmp)):
                    answer += 1
            tmp = ''
        else:
            tmp += i

    if len(tmp) > 0:
        if isPrime(int(tmp)):
            answer += 1

    return answer