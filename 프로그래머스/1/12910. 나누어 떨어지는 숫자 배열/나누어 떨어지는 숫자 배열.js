function solution(arr, divisor) {
    var answer = [];
    //[3,4,7,9] , 3 -> [3,9]
    for(let i=0; i<arr.length; i++){
        if(arr[i] % divisor === 0){
            answer.push(arr[i]);
        }
    }
    
    if(answer.length !== 0){
       return answer.sort((a,b)=>a-b);
    } else {
        return [-1];
    }
   
}