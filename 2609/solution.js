/*
const fs = require("fs");
const inputData = fs.readFileSync('/dev/stdin').toString();
*/
const fs = require("fs");
const input = fs.readFileSync('./input.txt').toString().split(" ");
const one = parseInt(input[0]);
const two = parseInt(input[1]);

function uclid(one, two) {
    let tmp = 0;

    while (two > 0) {
        tmp = one % two;
        one = two;
        two = tmp;
    }
    return one;
}

const maxDiv = uclid(one, two);

console.log(maxDiv);
console.log( Math.floor((one * two) / maxDiv));
