def solution(str1, str2):
    set1 = {}
    set2 = {}

    for i in range(len(str1) - 1):
        if str1[i].isalpha() and str1[i+1].isalpha():
            word = str1[i:i+2].lower()
            if word in set1:
                val = set1[word]
                set1[word] = val + 1
            else:
                set1[word] = 1

    for i in range(len(str2) - 1):
        if str2[i].isalpha() and str2[i+1].isalpha():
            word = str2[i:i + 2].lower()
            if word in set2:
                val = set2[word]
                set2[word] = val + 1
            else:
                set2[word] = 1

    if not set1 and not set2:
        return 65536

    union_cnt = 0
    for key in set1:
        if key in set2:
            union_cnt += min(set1[key], set2[key])

    total_cnt = 0
    for key in set1:
        if key in set2:
            total_cnt += max(set1[key], set2[key])
        else:
            total_cnt += set1[key]

    for key in set2:
        if key not in set1:
            total_cnt += set2[key]

    return int((union_cnt / total_cnt) * 65536)
