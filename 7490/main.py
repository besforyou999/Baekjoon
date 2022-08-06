import sys
from collections import deque
input = sys.stdin.readline

T = int(input())
array = []


def comb(number, string):
    if number == N:
        array.append(string)
        return

    comb(number + 1, string + '+' + str(number + 1))
    comb(number + 1, string + '-' + str(number + 1))
    comb(number + 1, string + ' ' + str(number + 1))


def build_all_zero():
    for item in array:
        string = item.replace(" ", "")
        buffer = ""
        numbers = deque([])
        symbols = deque([])
        for ch in string:
            if '1' <= ch <= '9':
                buffer += ch
            elif ch == '-' or ch == '+':
                numbers.append(buffer)
                symbols.append(ch)
                buffer = ""
        numbers.append(buffer)

        if len(symbols) == 0:
            continue

        while len(symbols) > 0:
            first = int(numbers.popleft())
            second = int(numbers.popleft())
            sym = symbols.popleft()
            if sym == '-':
                temp = first - second
            else:
                temp = first + second
            numbers.appendleft(temp)

        total = int(numbers.pop())

        if total == 0:
            answer_arr.append(item)


def print_all_zero():
    for item in answer_arr:
        print(item)


for _ in range(T):
    N = int(input())
    comb(1, '1')
    answer_arr = []
    build_all_zero()
    answer_arr.sort()
    print_all_zero()
    answer_arr = []
    array = []
    print()
