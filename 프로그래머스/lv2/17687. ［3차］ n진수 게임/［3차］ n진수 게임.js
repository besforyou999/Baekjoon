const buildOrderString = (n, t, m) => {
    let answer = '', number = 0;

    while (answer.length <= t * m) {
        let buffer = number.toString(n);

        for (let ch of buffer) answer += ch;
        
        number++;
    }

    return answer;
}

const buildAnswerString = (order, t, m, p) => {
    let answer = '', idx = p;

    while (idx < order.length && answer.length < t) {
        let ch = order[idx - 1];

        if (ch >= 'a' && ch <= 'z') {
            ch = String(ch).toUpperCase();
        }

        answer += ch;
        idx += m;
    }

    return answer;
}



const solution = (n, t, m, p) => {
    let order = buildOrderString(n, t, m);
    return buildAnswerString(order, t, m, p);
}


