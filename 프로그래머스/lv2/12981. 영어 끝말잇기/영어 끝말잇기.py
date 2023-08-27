def solution(n, words):
    word_set = set()

    for i in range(len(words)):

        # 이전에 한말인지 체크
        if words[i] in word_set:
            return [(i % n) + 1, (i // n) + 1]

        # 끝말잇기가 맞는지 체크
        if i >= 1:
            prev = words[i - 1]
            cur = words[i]
            if prev[-1] != cur[0]:
                return [(i % n) + 1, (i // n) + 1]

        word_set.add(words[i])

    return [0, 0]
