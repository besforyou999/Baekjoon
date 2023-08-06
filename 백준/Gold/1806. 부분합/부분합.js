const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");

const [N, S] = input[0].split(" ").map(e => Number(e));
const arr = input[1].split(" ").map(e => Number(e));

const sum = new Array(N + 1);
sum[0] = 0;
for (let i = 1 ; i < N + 1 ; i++) {
    sum[i] = sum[i-1] + arr[i- 1];
}

let lp = 0, rp = 1, min = 1_000_001, buff = sum[1];

while (rp <= N) {
    if (buff < S) {
        rp++;
    } else if (buff >= S) {
        let len = rp - lp;
        min = Math.min(min, len);
        lp++
    }

    if (rp > N || lp > N) break;
    buff = sum[rp] - sum[lp];
}

if (min === 1_000_001) {
    min = 0;
}

console.log(min);