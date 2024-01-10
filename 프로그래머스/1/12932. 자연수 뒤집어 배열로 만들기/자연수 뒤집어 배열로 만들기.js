function solution(n) {
    var answer = [];
    const arr = String(n).split('');
   
    for(let i=arr.length-1; i>=0; i--) {
       answer += arr[i] 
    }
    
    const newArr = Array.from(answer, function(str){
        return Number(str)
    });
    
    return newArr;
}