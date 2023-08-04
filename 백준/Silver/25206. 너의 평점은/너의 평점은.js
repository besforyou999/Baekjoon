const fs = require("fs");
// const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
const input = require('fs').readFileSync('/dev/stdin').toString().trim().split("\n").map(item => item.split(' '));

const Grade = {
    "A+": 4.5, A0: 4.0,
    "B+": 3.5, B0: 3.0,
    "C+": 2.5, C0: 2.0,
    "D+": 1.5, D0: 1.0,
    F : 0.0 
}

let score_multi_grade = 0;
let scoreSum = 0;

for (let [subject, score, grade] of input) {

    if (grade === 'P') continue;

    score_multi_grade += Number(score) * Grade[grade];
    scoreSum += Number(score);
}

console.log(score_multi_grade / scoreSum);