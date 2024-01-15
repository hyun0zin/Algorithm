function solution(n) {
    // 삽입 정렬로 풀기
    // n : 숫자 118373 -> 8,7,3,2,1,1         
    //숫자를 배열로 : [ 8,7,3,2,1,1]
    
    //map을 돌려서 배열 
    const newArr = n.toString().split('').map(Number); 
    console.log(newArr);
    
    // 삽입 정렬
    // 이중 루프
    for(let i=1; i < newArr.length; i++) {
        for (let j=i; j >0; j--) {
            if(newArr[j-1] < newArr[j]){
                let temp = newArr[j-1];
                newArr[j-1] = newArr[j];
                newArr[j] = temp;
            } else {
                break;
            }
        }
    }
    return parseInt(newArr.join(''))
}