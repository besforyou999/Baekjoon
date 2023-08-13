const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const [N, M] = fs.readFileSync(filePath).toString().split(" ").map(e => Number(e));

const GCD = (a, b) => {
    if (b == 0) return a;
    return GCD(b , a % b);
}

const gcd = GCD(N, M);

console.log(gcd);
console.log(N * M / gcd);