L, C = map(int, input().split())
alphas = list(input().split())
alphas.sort()

vowels = ['a', 'e', 'i', 'o', 'u']


def comb(r, start):
    if r == 0:
        tmp = ''
        for i in range(C):
            if visit[i]:
                tmp += alphas[i]

        # 모음이 최소 1개, 최소 2개 자음으로 구성되어 있으면 출력
        vowel_cnt = 0
        for ch in tmp:
            if ch in vowels:
                vowel_cnt += 1

        if vowel_cnt >= 1 and L - vowel_cnt >= 2:
            print(tmp)

        return

    for i in range(start, C):
        visit[i] = True
        comb(r - 1, i + 1)
        visit[i] = False


visit = [False] * C
comb(L, 0)