line = list(input())

letters = {}

for ch in line:
    ch = ch.upper()
    if ch in letters.keys():
        val = letters[ch]
        letters[ch] = val + 1
    else:
        letters[ch] = 1


keys = list(letters.keys())

max_cnt = -1
max_alpha = ''


for key in keys:
    cnt = letters[key]
    if cnt > max_cnt:
        max_cnt = cnt
        max_alpha = key


max_cnt_cnt = 0

for key in keys:
    cnt = letters[key]
    if max_cnt == cnt:
        max_cnt_cnt += 1


if max_cnt_cnt > 1:
    print('?')
else:
    print(max_alpha)