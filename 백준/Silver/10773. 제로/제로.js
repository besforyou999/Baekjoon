var fs = require('fs');
var input = fs.readFileSync('/dev/stdin').toString().split('\n');
var K = parseInt(input[0]);

let stack = [];

for (let i = 1 ; i <= K ; i++) {
    
    let n = parseInt(input[i]);
    
    if ( n == 0 ) {
        stack.pop();
    } else 
        stack.push(n);
}

let sum = 0;

for (const n of stack) {
    sum += n;
}

console.log(sum);
