const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', function (line) {
    input = line.split(' ');
}).on('close', function () {
    let str1 = 'a = ' + input[0];
    let str2 = 'b = ' + input[1];
    console.log(str1);
    console.log(str2);
});

