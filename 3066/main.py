import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    N = int(input())

    arr = [-1]
    for i in range(N):
        port_number = int(input())
        if arr[-1] < port_number:
            arr.append(port_number)
        else:
            lp = 0
            rp = len(arr)
            while lp < rp:
                mid = int((lp + rp) / 2)
                if arr[mid] < port_number:
                    lp = mid + 1
                else:
                    rp = mid
            arr[rp] = port_number

    print(len(arr) - 1)


