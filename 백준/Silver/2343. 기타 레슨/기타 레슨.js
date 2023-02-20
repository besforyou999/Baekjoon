const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().split("\n");
const n_m = input[0].split(' ').map((e) => { return parseInt(e) });
const lectures = input[1].split(' ').map((e) => { return parseInt(e) });
const N = n_m[0];
const M = n_m[1];
let l = 0 , r = 0;

for (let i = 0 ; i < N ; i++) {
    r += lectures[i];
    if (lectures[i] > l) {
        l = lectures[i];
    }
}

while (l <= r) {
    let mid = Math.floor((l + r) / 2);
    let sum = 0, blueray_num = 0;

    for (let i = 0 ; i < N ; i++) {
        if (sum + lectures[i] > mid) {
            sum = 0;
            blueray_num += 1;
        }
        sum += lectures[i];
    }

    if (sum != 0) blueray_num += 1;
    
    if (blueray_num > M) {
        l = mid + 1;
    } else {
        r = mid - 1;
    }
}

console.log(l);
