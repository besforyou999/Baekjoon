const fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('');
let setNum = 0 , ans1 = 0 , ans2 = 0;

for (let i = 0 ; i < input.length ; i++) {
    if (setNum != parseInt(input[i])) {
      if (i == 0) {
          ans1 += 1;
      } else {
          if (input[i] != input[i-1]) ans1 += 1;
      }
    }
}

setNum = 1;

for (let i = 0 ; i < input.length ; i++) {
    if (setNum != parseInt(input[i])) {
      if (i == 0) {
          ans2 += 1;
      } else {
          if (input[i] != input[i-1]) ans2 += 1;
      }
    }
}

console.log(Math.min(ans1, ans2));
