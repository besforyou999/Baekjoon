const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");
 
let answer = []; //정답이 될 이름들을 담을 배열
let N = parseInt(input.shift()); //학생 수
 
input = input
  .map((i) => i.split(" ").map((j) => Number(j) || j)) //input의 각 요소에 대해 공백기준으로 나누어서 배열화하고, number형으로 변환가능한 건 변환하고 아니면 string 그대로 변환
  .sort((a, b) => {
    if (a[1] < b[1]) return 1;
    //국어점수 비교(내림차순)
    else if (a[1] > b[1]) return -1;
    else {
      if (a[2] > b[2]) return 1;
      //영어점수 비교(오름차순)
      else if (a[2] < b[2]) return -1;
      else {
        if (a[3] < b[3]) return 1;
        //수학점수 비교(내림차순)
        else if (a[3] > b[3]) return -1;
        else {
          if (a[0] > b[0]) return 1;
          //이름 비교(오름차순)
          else if (a[0] < b[0]) return -1;
          else return 0;
        }
      }
    }
  });


input.forEach((i) => answer.push(i[0])); //조건대로 정렬된 input의 이름만 push
console.log(answer.join("\n")); //한줄단위로 이름 출력