// function solution(s) {
//     // s : "Zabed" -> [Z, a,b,c,d] : map
//     const newArr = s.split('').map(String)
//     // console.log(newArr)
    
//     // 삽입 정렬
//     for (let i=1; i<newArr.length; i++){
//         for(let j=i; j<0; j--){
//             if(newArr[j-1] < newArr[j]){
//                 let temp = newArr[j-1];
//                 newArr[j-1] = newArr[j];
//                 newArr[j] = temp;
                
//             }else{
//                 break;
//             }
            
//         }
//     }
//     return newArr.join('')
// }

function solution(s) {
    return s.split('').sort().reverse().join('');
}
