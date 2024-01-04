// function solution(numbers) {
//     let array = numbers;
//     const result = array.reduce(function add(a,b){
//         return a+b;
//     })
//     return result/array.length;
// }

function solution(numbers) {
    var sum = 0;
    for (i=0; i<numbers.length; i++){
       sum = sum + numbers[i];
    }
    return sum / numbers.length;
}