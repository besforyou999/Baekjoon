const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = fs.readFileSync(filePath).toString();

const N = Number(input);

for (let i = 1 ; i <= 9 ; i++) {
    console.log(`${N} * ${i} = ${N * i}`);
}