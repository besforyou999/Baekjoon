const solution = (n, k) => {

    let str = n.toString(k);
    let cnt = 0;

    for (let token of str.split('0')) {
        if (isPrime(Number(token))) cnt += 1;
    }

    return cnt;
}

const isPrime = number => {

    if (number < 2) 
        return false;

    if (number == 2) 
        return true;

    for (let i = 3 ; i <= Math.sqrt(number) ; i += 2) {
        if (number % i == 0) return false;
    }

    return true;
}