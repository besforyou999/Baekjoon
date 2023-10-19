def solution(want, number, discount):
    answer = 0

    comp = {}
    for i in range(len(want)):
        comp[want[i]] = number[i]

    dict = {}

    for i in range(10):
        food = discount[i]
        if food in dict:
            dict[food] += 1
        else:
            dict[food] = 1

    if comp == dict:
        answer += 1

    left, right = 0, 10

    while right < len(discount):
        out_food = discount[left]
        left += 1
        dict[out_food] -= 1
        if dict[out_food] == 0:
            dict.pop(out_food)

        in_food = discount[right]
        right += 1
        if in_food in dict:
            dict[in_food] += 1
        else:
            dict[in_food] = 1

        if comp == dict:
            answer += 1

    return answer