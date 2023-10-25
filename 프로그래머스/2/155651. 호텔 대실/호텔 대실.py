def change(time):
    hour, minute = map(int, time.split(":"))
    return hour * 60 + minute


def solution(book_time):
    answer = 0
    
    dp = [0] * 1451
    
    for s_hour, f_hour in book_time:
        s_min = change(s_hour)
        f_min = change(f_hour)
        
        for i in range(s_min, f_min + 10):
            dp[i] += 1
    
    for i in range(1440):
        if dp[i] != 0:
            answer = max(answer, dp[i])
    
    return answer