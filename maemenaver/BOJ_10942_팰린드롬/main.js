// 시간 초과, DP를 활용하여 풀어보자
// https://cocoon1787.tistory.com/326
const fs = require("fs");
// 백준 플랫폼이 리눅스기 때문. 로컬에서 테스트시 input.txt에 입력받을 내용을 입력 후 파일을 읽어오는식으로 테스트
const filePath = process.platform !== "darwin" ? "/dev/stdin" : "./input.txt";

let input = fs.readFileSync(filePath).toString().split("\n");
const arr = input[1].split(" ").map(v => parseInt(v))

const T = +input[2]

const memo = {

}
for (let i = 0; i < T; i++) {
    if (memo.start && memo.start.end !== undefined) {
        console.log(memo[start][end])
        continue;
    }

    const [start, end] = input[3 + i].split(" ").map(v => parseInt(v))

    const arrSub = arr.slice(start - 1, end)

    let result = 1

    let r = [];
    for (let j = 0; j < arrSub.length; j++) {
        r.push(arrSub.pop())
        // console.log(arrSub, r)
        if (arrSub[j] == undefined) {
            break;
        }
        if (arrSub[j] !== r[j]) {
            result = 0
            break;
        }
    }

    console.log(result)

    if (!memo[start]) {
        memo[start] = {}
    }

    memo[start][end] = result
}