def solution(k, tangerine):
    answer = 0

    dict = {}

    for t in tangerine:
        if t in dict:
            dict[t] += 1
        else:
            dict[t] = 1

    datas = []

    for key in dict:
        datas.append((key, dict[key]))

    datas = sorted(datas, key=lambda x: -x[1])

    while k > 0:
        key, value = datas[answer]
        k -= value
        answer += 1

    return answer