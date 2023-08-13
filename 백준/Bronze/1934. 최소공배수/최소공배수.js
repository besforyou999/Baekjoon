const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = fs.readFileSync(filePath).toString().split("\n");

const T = Number(input.shift());

const GCD = (a, b) => {
    if (b == 0) return a;
    return GCD(b , a % b);
}

let ans = "";

for (let i = 0 ; i < T ; i++) {
    const [A, B] = input[i].split(" ");
    const gcd = GCD(A, B);
    ans += A * B / gcd + "\n";
}

console.log(ans);