var fs = require('fs');
var input = fs.readFileSync('/dev/stdin').toString().split('\n');
const first_line = input[0].split(' ');

const N = parseInt(first_line[0]);
const M = parseInt(first_line[1]);

function find_minimum_cost(package_cost, single_cost, N) {
  let minimum_cost = Number.MAX_SAFE_INTEGER;
  let max_packages = ( N / 6  ).toFixed(0);
  
  for (let package_num = max_packages ; package_num >= 0 ; package_num--) {
    let single_num = ( N - 6 * package_num ) ? N >= 6 * package_num : 0;
    let cost = package_num * package_cost + single_num + single_cost;
    minimum_cost = Math.min(minimum_cost, cost);
  }
  return minimum_cost;
}

let ans = Number.MAX_SAFE_INTEGER;

for (let i = 1 ; i < M + 1 ; i++) {
  let line = input[i].split(' ');
  let package = parseInt(line[0]);
  let single = parseInt(line[1]);
  
  ans = Math.min(ans, find_minimum_cost(package, single, N));
}

console.log(ans);