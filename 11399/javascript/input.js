const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');
const len = parseInt(input[0]);
const Pi = input[1].split(' ');
Pi.sort( (a,b) => Number(a) - Number(b) );

const sum1 = 0, sum2 = 0;

for( let i = 0 ; i < len ; i++) {
	for ( let j = 0 ; j < i + 1 ; j++) {
		sum1 += Number(Pi[i]);
		sum2 += sum1;
	}
}

console.log(sum2);


