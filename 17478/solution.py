import sys
input = sys.stdin.readline
N = int(input())

bar_line = "____"
student_question = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다."
what_is_rec = '"재귀함수가 뭔가요?"'
jal = '"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.'
maul = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지."
gue = '그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."'
respond_rec = '"재귀함수는 자기 자신을 호출하는 함수라네"'
rago = "라고 답변하였지."


def rec(depth):
    head_line = ""
    for i in range(depth):
        head_line += bar_line
    print(head_line + what_is_rec)

    if depth == N:
        print(head_line + respond_rec)
        print(head_line + rago)
        return
    else:
        print(head_line + jal)
        print(head_line + maul)
        print(head_line + gue)
        rec(depth + 1)

    print(head_line + rago)


print(student_question)
rec(0)

