function solution(n) {
    
//     1. 10진법을 3진법으로 바꾸는 것
    let converted3 = '';
    while(n >= 3){
        converted3 += (n%3).toString();
        n = Math.floor(n/3);
        console.log('n :', n);
    }    
    console.log('converted3 :', converted3);
    
    let result = n.toString();
    for (let i = converted3.length-1; i >=0; i--){
        result += converted3[i];
    }
    console.log('result :', result);
    
        let answer = 0;
        for(let i=0; i<result.length; i++){
            answer += result[i]*(3**i);
        }
    return answer;
}