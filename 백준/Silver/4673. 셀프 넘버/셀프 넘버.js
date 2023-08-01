const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

const dn = (n) => {
  let str = String(n);
  let sum = n;
  for (let i = 0 ; i < str.length ; i++) {
    sum += Number(str[i]);
  }
  return sum;
}

const MAX = 10_000;
const visit = new Array(MAX + 1);
visit.fill(false);

for (let idx = 1 ; idx <= MAX ; idx++) {
  let num = idx;
  if (visit[num] == false) {
    visit[num] = true;
    
    console.log(num);

    while (num <= MAX) {
      num = dn(num);
      visit[num] = true;
    }
  }
}