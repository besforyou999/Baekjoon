from itertools import product


def solution(word):
    words = []

    letters = ['A', 'E', 'I', 'O', 'U']

    for i in range(1, 6):
        for perm in product(letters, repeat=i):
            tmp = ''

            for ch in perm:
                tmp += ch

            words.append(tmp)

    words.sort()

    for i in range(len(words)):
        if word == words[i]:
            return i + 1

    return -1