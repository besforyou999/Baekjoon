/*
const fs = require("fs");
const inputData = fs.readFileSync('/dev/stdin').toString();
*/
const fs = require("fs");
const input = fs.readFileSync('./input.txt').toString().split(" ");
const M = parseInt(input[0]);
const N = parseInt(input[1]);


const arr = new Array(N + 1).fill(false);
arr[0] = arr[1] = true;

for (let i = 2 ; i * i <= N ; i++) {
    if (arr[i] == false)
        for (let j = i * i ; j <= N ; j += i)
            arr[j] = true;
}

const results = [];

for (let i = N; i <= M ; i++) {
    if (arr[i] == false) 
        results.push(i);
}

console.log(results.join('\n'));

