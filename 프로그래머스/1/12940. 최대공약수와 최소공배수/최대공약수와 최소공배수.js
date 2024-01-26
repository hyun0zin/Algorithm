function solution(n, m) {
    let maxNumberArr = [];
    for(let i=1; i<=Math.max(n,m); i++){
        if((n % i === 0) && (m % i === 0)){
           maxNumberArr.push(i);
            
        }
    }
   const maxNumber = (maxNumberArr[maxNumberArr.length-1])
   console.log(maxNumber)
    const minNumber = n*m/maxNumber
    console.log(minNumber)
    return [maxNumber, minNumber]
}
