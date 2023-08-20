import sys
input = sys.stdin.readline

P = int(input())

for tc in range(1, P + 1):
    students = list(map(int, input().split()))

    backup_cnt = 0
    line = [students[1]]

    for i in range(2, 21):
        new_height = students[i]
        insert = False
        for j in range(len(line)):
            if line[j] > new_height:
                line.insert(j, new_height)
                backup_cnt += len(line) - j - 1
                insert = True
                break

        if not insert:
            line.append(new_height)
        
    print(str(tc) + ' ' + str(backup_cnt))