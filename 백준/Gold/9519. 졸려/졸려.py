X = int(input())
letter = input().rstrip()


def convert(string):
    N = len(string)
    idx = N // 2
    if N % 2 == 1:
        idx += 1
    front = string[:idx]
    back = string[idx:]

    new_string = ''

    for i in range(len(back)):
        new_string += front[i]
        new_string += back[-1 - i]

    if N % 2 == 1:
        new_string += front[-1]

    return new_string


letters = {}
cnt = 0
while True:
    letters[letter] = cnt
    cnt += 1

    letter = convert(letter)
    if letter in letters:
        break


cnt = letters[letter]
X %= len(letters)

for _ in range(X):
    cnt -= 1
    if cnt < 0:
        cnt = len(letters) - 1

for key in letters:
    if letters[key] == cnt:
        print(key)
        break