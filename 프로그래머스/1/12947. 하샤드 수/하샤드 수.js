function solution(x)
{

    // 1. 숫자 -> 배열로 먼저 만들기
    const str = String(x);
    const newArr = str.split('') 

    // 2. 배열 내 숫자들 합 구하기
    var sum = 0; 
    for(let i=0; i<newArr.length; i++){
        sum = sum + Number(newArr[i]);        
    } 
    
    let answer = (x%sum === 0) ? true : false;
    return answer;
}