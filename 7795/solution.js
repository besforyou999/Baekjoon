const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().split("\n");
let inputLine = 0;
const T = parseInt(input[inputLine++]);

for (let i = 0 ; i < T ; i++) {
    let N_M = input[inputLine++].split(' ');
    let N = parseInt(N_M[0]);
    let M = parseInt(N_M[1]);
    let A = input[inputLine++].split(' ').map((ele) => {return parseInt(ele)}).sort(compare);
    let B = input[inputLine++].split(' ').map((ele) => {return parseInt(ele)}).sort(compare);
    let count = 0;
    A.forEach((a) => { count += (smallerFishNum(a, B) + 1); });
    console.log(count);
}

function compare(a, b) {
    if ( a > b ) {
        return 1;
    } else if ( a < b ) {
        return -1;
    } else 
        return 0;
}

function smallerFishNum(fish, arr) {
    let lp = 0;
    let rp = arr.length - 1;
    let res = -1;
    while ( lp <= rp ) {
        let m = parseInt((lp + rp) / 2);
        if ( arr[m] < fish ) {
            res = m;
            lp = m + 1;
        } else {
            rp = m - 1;
        }
    }
    
    return res;
}
