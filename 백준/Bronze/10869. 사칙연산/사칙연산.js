const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let [a, b] = fs.readFileSync(filePath).toString().split(" ").map( e => Number(e));

console.log(a + b);
console.log(a - b);
console.log(a * b);
console.log( Math.floor(a / b));
console.log(a % b);