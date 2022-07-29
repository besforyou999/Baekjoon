from sys import stdin
from itertools import combinations

L, C = map(int, stdin.readline().rstrip().split())
characters = list(map(str, stdin.readline().rstrip().split(' ')))
characters.sort()
answers = list(combinations(characters, L))
answer_str = []

vowels = set(['a', 'e', 'i', 'o', 'u'])

for t in answers:
    temp = ""
    vowel = 0
    not_vowel = 0
    for i in range(L):
        ch = t[i]
        temp += ch
        if ch in vowels:
            vowel += 1
        else:
            not_vowel += 1

    if vowel >= 1 and not_vowel >= 2:
        answer_str.append(temp)

print("\n".join(map(str, answer_str)))

