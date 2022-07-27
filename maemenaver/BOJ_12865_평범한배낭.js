// 틀림

const fs = require("fs");
// 백준 플랫폼이 리눅스기 때문. 로컬에서 테스트시 input.txt에 입력받을 내용을 입력 후 파일을 읽어오는식으로 테스트
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";

let input = fs.readFileSync(filePath).toString().split("\n");
input = input.map(v => v.split(" ").map(v => parseInt(v)))

const [N, K] = input[0]
input.shift()

const memo = new Array(K + 1).fill(0)

class Node {
    next = []; // [[4,8], [3,6], [5,12]]
    weight = 0; // 6
    value = 0; // 13

    constructor(_weight, _value, _next) {
        this.weight = _weight;
        this.value = _value;
        this.next = _next;
    }

    setMemo() {
        while (this.next.length > 0) {
            const [nextWeight, nextValue] = this.next.pop();
            if (this.weight + nextWeight > K) {
                continue
            }
            if (memo[this.weight + nextWeight] < this.value + nextValue) {
                new Node(this.weight + nextWeight, this.value + nextValue, [...this.next.filter(v => v !== this)]).setMemo();
            }
        }

        if (this.weight <= K) {
            memo[this.weight] = Math.max(memo[this.weight], this.value);
        }
    }
}

for (let i = 0; i < input.length; i++) {
    new Node(input[i][0], input[i][1], [...input.filter(v => v !== input[i])]).setMemo()
}

memo.sort((a, b) => b - a)

console.log(memo[0])