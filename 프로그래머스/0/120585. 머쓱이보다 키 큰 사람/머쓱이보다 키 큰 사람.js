function solution(array, height) {
    const newArray = []
    for(let i=0; i<array.length; i++){
        if(array[i] > height){
            newArray.push(array[i])
        }
    }
console.log(newArray)
    return newArray.length;
}