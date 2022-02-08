const MAX = 10001;
let arr = new Array(MAX);
arr.fill(0);

function main() {

    for (let i = 1 ; i < MAX ; i++) {
        if (arr[i] != 0) continue;
        else make_seq(i);
    }

}

function make_seq(n) {
    let d_n = d(n);
    arr[d_n] = d_n;
    if (d_n < MAX) make_seq(d_n);
}


function d(n) {

    let sum = n;
    let str = String(n);

    for (let i = 0 ; i < str.length ; i++) sum += parseInt(str.charAt(i));
    
    return sum;
}

function printArr() {
   for (let i = 1 ; i < 100 ; i++) {
       if (arr[i] == 0) console.log(i);
   }
}

main();

printArr();