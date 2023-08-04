const infos = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n').map(item=>item.split(' '));

let sum = 0;
let total = 0;

const table = {
	"A+": 4.5, A0: 4.0,
	"B+": 3.5, B0: 3.0,
	"C+": 2.5, C0: 2.0,
	"D+": 1.5, D0: 1.0,
	F: 0.0
} // key-value 로 저장해둔평점

for(let [sub, score, grade] of infos) {
   
    let num = 0;
    
   if(grade==='P') {
        continue;
    } // p일 경우 빼고 계산
    sum += Number(score)*table[grade] // 학점에 따라서 key 값으로 table에서 빼와서 계산
    total += Number(score); // total 값 저장
} 
console.log(sum/total); // 전공과목별 학점*평점을 총점으로 나누어 출력