const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");

const max = 101;

const mat = new Array(max);
for (let i = 0 ; i < max ; i++) {
    mat[i] = new Array(max);
    mat[i].fill(0);
}

for (const line of input) {
    const [x1, y1, x2, y2] = line.split(" ").map(e => Number(e));

    for (let r = y1 ; r < y2 ; r++) {
        for (let c = x1 ; c < x2; c++) {
            mat[r][c] = 1;
        }
    }
}

let ans = 0;

for (let r = 0 ; r < max ; r++) {
    for (let c = 0 ; c < max ; c++) {
        if (mat[r][c] == 1) {
            ans += 1;
        }
    }
}

console.log(ans);