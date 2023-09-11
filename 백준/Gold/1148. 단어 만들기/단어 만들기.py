import sys

words = []

while True:
    line = sys.stdin.readline().rstrip()
    if line == "-":
        break
    words.append(line)


while True:
    line = sys.stdin.readline().rstrip()
    if line == "#":
        break

    alphas = {}
    for p in line:
        if not alphas.get(p):
            alphas[p] = {'cnt': 1, 'used_cnt': 0}
        else:
            alphas[p]['cnt'] += 1

    for word in words:
        available = True
        for w in set(word):
            w_cnt = word.count(w)

            if not alphas.get(w) or w_cnt > alphas[w]['cnt']:
                available = False
                break

        if available:
            for w in set(word):
                alphas[w]['used_cnt'] += 1

    min_ans, max_ans = 1e9, -1

    for key in alphas:
        min_ans = min(alphas[key]['used_cnt'], min_ans)
        max_ans = max(alphas[key]['used_cnt'], max_ans)

    min_words = "".join(sorted([key for key in alphas if alphas[key]['used_cnt'] == min_ans]))
    max_words = "".join(sorted([key for key in alphas if alphas[key]['used_cnt'] == max_ans]))

    print(min_words, min_ans, max_words, max_ans)