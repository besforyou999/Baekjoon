const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

class Node {
  constructor(number) {
    this.number = number;
    this.next = null;
  }
}

class Queue {
  constructor() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  push(item) {
    const node = new Node(item);
    if (!this.head) {
      this.head = node;
      this.head.next = this.tail;
    } else {
      this.tail.next = node;
    }
    this.tail = node;
    this.size += 1;
  }

  getSize() {
    return this.size;
  }

  pop() {
    if (this.size > 2) {
      const number = this.head.number;
      const newHead = this.head.next;
      this.head = newHead;
      this.size -= 1;
      return number;
    } else if (this.size === 2) {
      const number = this.head.number;
      const newHead = this.head.next;
      this.head = newHead;
      this.tail = newHead;
      this.size -= 1;
      return number;
    } else if (this.size === 1) {
      const number = this.head.number;
      this.head = null;
      this.tail = null;
      this.size -= 1;
      return number;
    } else {
      return -1;
    }
  }

  empty() {
    return this.size ? 0 : 1;
  }

  front() {
    return this.head ? this.head.number : -1;
  }

  back() {
    return this.tail ? this.tail.number : -1;
  }
}

const queue = new Queue();

let N = input.shift();

let answer = '';

for (const item of input) {

  ele = item.split(' ');

  switch(ele[0]) {
    case 'push': {
      queue.push(ele[1]);
      break;
    }
    case 'pop': {
      answer += queue.pop() + ' ';
      break;
    }
    case 'size': {
      answer += queue.getSize() + ' ';
      break;
    }
    case 'empty': {
      answer += queue.empty() + ' ';
      break;
    }
    case 'front': {
      answer += queue.front() + ' ';
      break;
    }
    case 'back': {
      answer += queue.back() + ' ';
      break;
    }
  }
}


console.log(answer.split(' ').join("\n"));