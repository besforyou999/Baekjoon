function solution(n) {
    
    if (n == 0)
        return 0
    
    let half = n / 2
    let left = 2
    
    const set = new Set()
    set.add(1)
    set.add(n)
    
    while (left <= half) {
        if (n % left == 0) {
            set.add(left)
            set.add(n / left)
        }
        left++;
    }
    
    var answer = 0;
    
    for (const ele of set) {
        answer += ele
    }
    
    return answer;
}