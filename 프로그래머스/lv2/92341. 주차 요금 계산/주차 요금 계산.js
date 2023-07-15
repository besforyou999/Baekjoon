const solution = (fees, records) => {
    const answer = [];

    const in_record = new Map();
    const parkedMinutes = new Map();
    
    for (let record of records) {
        const tokens = record.split(" ");

        const time = timeToMinute(tokens[0]);
        const carNumber = tokens[1];
        const cmd = tokens[2];

        if (cmd == 'IN') {
            in_record.set(carNumber, time);
        } else {
            const inTime = in_record.get(carNumber);
            if (parkedMinutes.has(carNumber)) {
                const timeSum = parkedMinutes.get(carNumber);
                parkedMinutes.set(carNumber, timeSum + (time - inTime));
            } else {
                parkedMinutes.set(carNumber, time - inTime);
            }

            in_record.delete(carNumber);
        }
    }

    // 출차 기록 없는 차량 (23:59 출차로 간주)
    for (const element of in_record) {
                
        const carNumber = element[0];

        const inTime = in_record.get(carNumber);
        const outTime = timeToMinute("23:59");

        if (parkedMinutes.has(carNumber)) {
            const timeSum = parkedMinutes.get(carNumber);
            parkedMinutes.set(carNumber, timeSum + (outTime - inTime));
        } else {
            parkedMinutes.set(carNumber, outTime - inTime);
        }
    }

    const carNumbers = [];
    
    for (const ele of parkedMinutes) {
        carNumbers.push(ele[0]);
    }

    carNumbers.sort( (a, b) => {
        return Number(a) - Number(b);
    });

    for (const carNumber of carNumbers) {
        const parkedMinute = parkedMinutes.get(carNumber);
        answer.push(calcCost(fees, parkedMinute));
    }

    return answer;
}

const calcCost = (fee, parkedMinutes) => {

    if (fee[0] >= parkedMinutes) {  // 기본요금
        return fee[1];
    } else { // 기본요금 + 초과요금
        const overTime = parkedMinutes - fee[0];
        const division = Math.ceil(overTime / fee[2]);
        return fee[1] + division * fee[3];
    }

}

const timeToMinute = time => {
    let tokens = time.split(":");
    return Number(tokens[0]) * 60 + Number(tokens[1]);
}

