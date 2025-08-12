class Solution {
    public String solution(int[] food) {
        String answer = "";
        // 빈 문자열 -> 나중에 reverse로 뒤에 붙이기
        String charArr = "";
        for(int i=1; i<food.length; i++){
                for(int j=0; j<food[i]/2; j++){
                    charArr += i;
                }
            
        }
        
        String reverseCharArr = "";
        for(int i=charArr.length()-1; i>=0; i--){
            reverseCharArr += charArr.charAt(i);
        }
        answer = charArr + 0 + reverseCharArr;
        
        return answer;
    }
}