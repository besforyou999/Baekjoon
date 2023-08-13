const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const [A, B, C] = fs.readFileSync(filePath).toString().split(" ").map(e => Number(e));

console.log( (A + B) % C );
console.log( ((A % C) + (B % C)) % C );
console.log( (A * B) % C );
console.log( ((A % C) * (B % C)) % C );