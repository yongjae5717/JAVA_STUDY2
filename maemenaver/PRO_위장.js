function solution(clothes) {
    const result = {}

    for (const [name, _type] of clothes) {
        if (result[_type] === undefined) {
            result[_type] = []
        }

        result[_type].push(name)
    }

    let sum = 1
    for (const [key, value] of Object.entries(result)) {
        sum *= value.length + 1
    }

    return sum - 1;
}