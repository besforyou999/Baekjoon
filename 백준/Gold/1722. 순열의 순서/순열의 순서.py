import math


def find_one(n, k):
    if len(answer) == N - 1:
        answer.append(numbers[-1])
        return

    fact = math.factorial(n)
    idx = math.ceil(k / fact)
    answer.append(numbers.pop(idx))
    find_one(n - 1, k - ((idx - 1) * fact))


def find_k():
    n = N - 1
    for num in K:
        fact = math.factorial(n)
        idx = numbers.index(num)
        if len(numbers) == 2:
            idx += 1
            answer.append(fact * idx)
            return
        numbers.pop(idx)
        answer.append(fact * idx)
        n -= 1


if __name__ == "__main__":
    N = int(input())
    tmp_input = list(map(int, input().split()))
    order = tmp_input.pop(0)

    # 소문제 1
    if order == 1:
        K = tmp_input[0]
        numbers = [i for i in range(N + 1)]
        answer = []
        find_one(N - 1, K)
        print(' '.join(list(map(str, answer))))
    else:
        K = tmp_input
        numbers = [x for x in range(1, N + 1)]
        answer = []
        find_k()
        print(sum(answer))