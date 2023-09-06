def solution(sequence, k):

    N = len(sequence)
    lp = 0
    rp = 0
    sum = sequence[0]
    results = []
    while lp < N:
        if sum < k:
            rp += 1
            if rp >= N:
                sum -= sequence[lp]
                lp += 1
                continue
            sum += sequence[rp]
        elif sum > k:
            sum -= sequence[lp]
            lp += 1
        else:
            results.append((lp, rp))
            sum -= sequence[lp]
            lp += 1

    results.sort(key=lambda e: e[1] - e[0])

    min_length = results[0][1] - results[0][0]

    answers = [x for x in results if x[1] - x[0] == min_length]

    answers.sort(key=lambda e: e[0])

    return [answers[0][0], answers[0][1]]