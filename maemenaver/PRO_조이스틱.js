// 좀 더 풀어보자

let name;
let cnt = 0;
let cursorIdx = 0;

function prevAlphabet() {
    cursorIdx = cursorIdx <= 0 ? name.length - 1 : cursorIdx - 1;
    cnt += 1;
}

function nextAlphabet() {
    cursorIdx = cursorIdx >= name.length - 1 ? 0 : cursorIdx + 1;
    cnt += 1;
}

function solution(_name) {
    _nameSplit = _name.split("")
    name = new Array(_name.length).fill("A")

    startA = 0;
    endA = 0;

    for (let i = 1; i < _nameSplit.length; i++) {
        if (_nameSplit[i] === "A") {
            startA += 1;
            continue
        }

        break;
    }

    for (let i = _nameSplit.length - 1; i > 0; i--) {
        if (_nameSplit[i] === "A") {
            endA += 1;
            continue
        }

        break;
    }
}

// 테스트 16, 17 === 0