function solution(num) {
    const workingCount = (num, loopCount)=>{
        if(num === 1){
            return loopCount
        } 
        const calculateNum = (num%2===0) ? num/2 : num*3 +1 ;
        return workingCount(calculateNum, loopCount +1)
    }
    
    const loopCount = workingCount(num, 0);
    const answer = loopCount<500 ? loopCount : -1;
    return answer;
}