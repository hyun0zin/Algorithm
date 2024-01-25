function solution(phone_number) {
    const changeNumber= phone_number.slice(0,phone_number.length-4);
    const starCount = "*".repeat(changeNumber.length);
    const answer = phone_number.replace(changeNumber, starCount)
   
 return answer;
    
    
}