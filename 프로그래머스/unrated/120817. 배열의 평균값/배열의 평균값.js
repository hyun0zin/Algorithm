function solution(numbers) {
    let array = numbers;
    const result = array.reduce(function add(a,b){
        return a+b;
    })
    return result/array.length;
}
