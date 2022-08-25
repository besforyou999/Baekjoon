import sys
input = sys.stdin.readline

N = int(input())

max_three = int(N / 3)
max_five = int(N / 5)

three_bag = 0

minimum_bag = sys.maxsize

while three_bag <= max_three:
    remain = N - (3 * three_bag)
    if remain % 5 == 0:
        five_bag = int(remain / 5)
        bag_sum = three_bag + five_bag
        minimum_bag = min(minimum_bag, bag_sum)
    three_bag += 1

if minimum_bag == sys.maxsize:
    print(-1)
else:
    print(minimum_bag)





