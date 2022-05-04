
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString();

//let input = 380;

function counter(input) {
    let ans = 1000 - parseInt(input);
    let count = 0;
    
    count += Number(( ans / 500 ).toFixed(0));
    ans = ans % 500;
    if ( ans == 0 ) return count;
    
    count += Number(( ans / 100 ).toFixed(0));
    ans = ans % 100;
    if ( ans == 0 ) return count;
    
    count += Number(( ans / 50 ).toFixed(0));
    ans = ans % 50;
    if ( ans == 0 ) return count;
    
    count += Number(( ans / 10 ).toFixed(0));
    ans = ans % 10;
    if ( ans == 0 ) return count;
    
    count += Number(( ans / 5 ).toFixed(0));
    ans = ans % 5;
    if ( ans == 0 ) return count;
    
    count += Number(( ans / 1 ).toFixed(0));
    ans = ans % 1;

    return count;
}

console.log(counter(input));