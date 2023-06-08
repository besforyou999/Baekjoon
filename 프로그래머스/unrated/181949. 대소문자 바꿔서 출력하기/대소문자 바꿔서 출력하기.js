const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function isUpper(str) {
    if (str == str.toUpperCase()) {
        return true;
    }
    return false;
}

function isLower(str) {
    if (str == str.toLowerCase()) {
        return true;
    }
    return false;
}

let input = [];

rl.on('line', function (line) {
    input = [line];
}).on('close',function(){
    str = input[0];
    
    let answer = '';
    
    for (let i = 0 ; i < str.length ; i++) {
        let ch = str.charAt(i);
        
        if (isUpper(ch)) {
            answer += ch.toLowerCase();
        } else
            answer += ch.toUpperCase();
    }
    
    console.log(answer);
    
});

