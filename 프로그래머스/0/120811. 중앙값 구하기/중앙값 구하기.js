function solution(array) {
 array.sort(function(a,b){
      return a-b;
  })
  console.log(array)
return (array[Math.floor(array.length/2)])
}