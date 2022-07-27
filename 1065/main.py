def is_han(number):
    if number <= 99:
        return True

    string = str(number)
    diff = int(string[0]) - int(string[1])
    length = len(string)
    if length == 3:
        diff2 = int(string[1]) - int(string[2])
        if diff2 == diff:
            return True
        else:
            return False

    if length == 4:
        diff2 = int(string[1]) - int(string[2])
        diff3 = int(string[2]) - int(string[3])
        if diff2 == diff and diff3 == diff and diff2 == diff3:
            return True
        else:
            return False


n = int(input())
count = 0

for idx in range(1, n+1):
    if is_han(idx) is True:
        count += 1


print(count)

