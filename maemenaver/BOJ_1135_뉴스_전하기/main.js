// 틀렸습니다..

class Node {
    id = 0;
    parent = null;
    child = [];
    level = 1;
    maxLevel = 1;
    maxCount = 1;

    setMaxLevel(level) {
        this.maxLevel = level;

        if (this.parent !== null) {
            this.parent.setMaxLevel(level)
        }
    }

    setMaxCount() {
        for (const idx in this.child) {
            const c = this.child[idx];

            if (c.child.length > 0) {
                c.setMaxCount()
            }

            this.maxCount = Math.max(this.maxCount + 1, c.maxCount + 1)
        }

        if (this.child.length > 1) {
            this.child.sort((a, b) => b.maxCount - a.maxCount)
        }
    }
}

const memo = []

const fs = require("fs");
// 백준 플랫폼이 리눅스기 때문. 로컬에서 테스트시 input.txt에 입력받을 내용을 입력 후 파일을 읽어오는식으로 테스트
const filePath = process.platform !== "darwin" ? "/dev/stdin" : "./input.txt";

let input = fs.readFileSync(filePath).toString().split("\n");

const arr = input[1].split(" ").map(v => parseInt(v))

for (let currentIdx = 0; currentIdx < arr.length; currentIdx++) {
    const parentIdx = arr[currentIdx];
    const parent = memo[parentIdx];

    const current = new Node()
    memo.push(current)

    if (parentIdx !== -1) {
        current.id = currentIdx;
        current.parent = parent;
        current.level = current.parent.level + 1

        current.parent.child.push(current)

        current.setMaxLevel(current.level)
    }
}

memo[0].setMaxCount()

console.log(memo[0].child[0].maxCount)