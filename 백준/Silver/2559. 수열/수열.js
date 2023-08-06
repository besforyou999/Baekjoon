const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");

const [N, K] = input[0].split(" ").map(e => Number(e));
const arr = input[1].split(" ").map(e => Number(e));

let i = 0, sum = 0;

while (i < K) sum += arr[i++];

let max = sum;

while (i < N) {
    sum += arr[i] - arr[i - K];
    if (max < sum) {
        max = sum;
    }
    i++;
}

console.log(max);