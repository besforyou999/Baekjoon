var fs = require('fs');
var input = fs.readFileSync('/dev/stdin').toString().split('\n');
var N = parseInt(input[0]);

let deque = [];

for (let i = 1 ; i <= N ; i++) {

	var str = input[i].spilt(' ');

	var order = str[0];
	var num = str[1];

	switch(order) {
		case "push_front" : {
			let array1 = [Number(num)];
			deque = array1.concat(deque);
			break;
		}
		case "push_back" : {
			deque.push(num);
			break;
		}
		case "front" : {
			console.log(deque.indexOf(0));
			break;
		}
		case "back" : {
			console.log(deque.lastIndexOf());
			break;
		}
		case "size" : {
			console.log(deque.length);
			break;
		}
		case "empty" : {
			if (deque.isEmpty())
				console.log(1);
			else
				console.log(0);
			break;
		}
		case "pop_front" : {
			if (deque.isEmpty()) {
				console.log(-1);
				break;
			}
			console.log(deque.shift());
			break;
		}
		case "pop_back" : {
			if (deque.isEmpty()) {
				console.log(-1);
				break;
			}
			console.log(deque.pop());	
			break;
		}
	}
}
