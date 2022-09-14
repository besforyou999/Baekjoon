from itertools import combinations
import sys
input = sys.stdin.readline

L, C = map(int, input().split())
letters = map(str, input().split())
vowels = set(['a', 'e', 'i', 'o', 'u'])


def validate(line):
    vowel = 0
    for ch in line:
        if ch in vowels:
            vowel += 1

    nonvowel = len(line) - vowel

    if vowel >= 1 and nonvowel >= 2:
        return True
    return False


answers = []

combination = combinations(letters, L)

for combo in combination:
    combo = sorted(combo)
    sample = ''.join(combo)
    if validate(sample):
        answers.append(sample)

answers.sort()

for l in answers:
    print(l)

