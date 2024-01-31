function solution(s) {
    const newArr = s.split('')
    let answer = newArr.sort().reverse().join('')
    console.log(answer)
    return answer
}
// function solution(s) {
//     return s.split('').sort().reverse().join('');
// }
