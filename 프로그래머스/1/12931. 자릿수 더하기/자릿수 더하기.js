function solution(n)
{
    var answer = 0;
    
    // 1. 숫자 -> 배열로 먼저 만들기
    // 1-1 숫자 -> 문자열 -> split -> 배열
    
    const str = String(n);
    const newArr = str.split('') 
    
    // 2. 배열 내 숫자들 합 구하기
    var sum = 0; 
    for(let i=0; i<newArr.length; i++){
        // 배열 내 값들 '문자열' 이므로 -> '숫자'로 변경하기
        sum = sum + Number(newArr[i]);        
    } 

    return sum;
}