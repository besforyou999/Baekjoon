/*
let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split(' ');
let a = input[0];
let b = input[1];
*/

function calc_min(a,b) {
    let min_a = "", min_b = "";

    for (let i = 0 ; i < a.length ; i++) {
        if ( a[i] == "6" ) {
            min_a = min_a + "5";
        } else {
            min_a = min_a + a[i];
        }
    }

    for (let i = 0 ; i < b.length ; i++) {
        if ( b[i] == "6" ) {
            min_b = min_b + "5";
        } else {
            min_b = min_b + b[i];
        }
    }

    return ( parseInt(min_a) + parseInt(min_b) );
}

function calc_max(a,b) {
    let max_a = "", max_b = "";

    for (let i = 0 ; i < a.length ; i++) {
        if ( a[i] == "5" ) {
            max_a = max_a + "6";
        } else {
            max_a = max_a + a[i];
        }
    }

    for (let i = 0 ; i < b.length ; i++) {
        if ( b[i] == "5" ) {
            max_b = max_b + "6";
        } else {
            max_b = max_b + b[i];
        }
    }

    return ( parseInt(max_a) + parseInt(max_b) );
}

let a = "11";
let b = "25";

let min = calc_min(a,b);
let max = calc_max(a,b);


console.log(calc_min(a,b), calc_max(a,b));


