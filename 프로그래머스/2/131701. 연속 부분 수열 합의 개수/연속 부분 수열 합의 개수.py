def solution(elements):
    answer = set()
    n = len(elements)

    for l in range(n):
        left = 0
        right = l

        tmp = sum(elements[left: right + 1])
        answer.add(tmp)

        while left < n:
            tmp -= elements[left]
            left += 1

            right += 1

            if right >= n:
                right = 0

            tmp += elements[right]

            answer.add(tmp)

    return len(answer)