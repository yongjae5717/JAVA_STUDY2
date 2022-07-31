// 틀렸습니다..

class Node {
    id = 0;
    parent = null;
    child = [];
    level = 1;
    maxLevel = 1;
    maxCount = 1;
    minCount = 0;

    setMaxLevel(level) {
        this.maxLevel = level;

        if (this.parent !== null) {
            this.parent.setMaxLevel(level)
        }
    }

    // setMaxCount() {
    //     for (const idx in this.child) {
    //         const c = this.child[idx];

    //         if (c.child.length > 0) {
    //             c.setMaxCount()
    //         }

    //         if (idx == 0) {
    //             this.maxCount = c.maxCount + 1;
    //         } else {
    //             this.maxCount = Math.max(this.maxCount, c.maxCount + 1)
    //         }
    //     }

    //     if (this.child.length > 1) {
    //         this.child.sort((a, b) => b.maxCount - a.maxCount)
    //     }
    // }

    setMinCount() {
        if (this.child.length === 0) {
            this.minCount = 0;
            return
        }

        for (const idx in this.child) {
            const c = this.child[idx];
            c.setMinCount()

            if (idx == 0) {
                this.minCount = c.minCount + 1;
            } else {
                this.minCount = Math.max(this.minCount, c.minCount + (+idx) + 1)
            }
        }

        this.child.sort((a, b) => b.minCount - a.minCount)
    }
}

const memo = []

const fs = require("fs");
// 백준 플랫폼이 리눅스기 때문. 로컬에서 테스트시 input.txt에 입력받을 내용을 입력 후 파일을 읽어오는식으로 테스트
const filePath = (process.platform !== "darwin" && process.platform !== "win32") ? "/dev/stdin" : "./input.txt";

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

memo[0].setMinCount()
memo[0].setMinCount()
memo[0].setMinCount()

console.log(memo[0].minCount)