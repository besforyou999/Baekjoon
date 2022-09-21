/*
const fs = require("fs");
const inputData = fs.readFileSync('/dev/stdin').toString();
*/
const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().split("\n");
const N = parseInt(input[0]);
const numbers = input[1].split(' ').map((e) => { return parseInt(e); });

function isPrime(num) {
    if (num == 1) return 0;

    for (let i = 2 ; i <= Math.sqrt(num) ; i++) {
        if (num % i == 0) return 0;
    }

    return 1;
}

let ans = 0;

numbers.forEach((num) => {
    if (isPrime(num)) ans += 1;
});

console.log(ans);
