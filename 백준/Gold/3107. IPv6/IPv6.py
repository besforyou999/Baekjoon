import sys

line = input()

idx = 0
contain_rule2 = False

for i in range(len(line) - 1):
    if line[i] == ':' and line[i + 1] == ':':
        contain_rule2 = True
        idx = i
        break

tokens = line.split(":")

if contain_rule2:
    if idx == 0:
        tokens = [token for token in tokens if token != '']
        while len(tokens) < 8:
            tokens.insert(0, '0000')
    elif idx == len(line) - 2:
        tokens = [token for token in tokens if token != '']
        while len(tokens) < 8:
            tokens.append('0000')
    else:
        blank_idx = 0
        for i in range(len(tokens)):
            if tokens[i] == '':
                blank_idx = i
                break

        tokens = [token for token in tokens if token != '']
        while len(tokens) < 8:
            tokens.insert(blank_idx, '0000')

for i in range(len(tokens)):
    token = tokens[i]
    size = len(token)
    for _ in range(4 - size):
        token = '0' + token
    tokens[i] = token

print(":".join(tokens))