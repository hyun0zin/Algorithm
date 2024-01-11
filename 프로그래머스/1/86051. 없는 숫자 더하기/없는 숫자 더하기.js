function solution(numbers) {
    const arr =[];
    for (let i =0; i<10; i++){
        arr.push(false);
    }
    for (let i=0; i <numbers.length; i++){
        let paintedIndex = numbers[i];
        arr[paintedIndex] = true;
         }
    
    let sum =0; 
    for (let i =0; i <arr.length; i++){
        if(!arr[i]){
            sum += i;
        }
    }
    return sum;
}