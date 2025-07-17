class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        answer[0] = -1;
        
        for(int i=1; i<s.length(); i++){
            int num = 987654321;
            for(int j=0; j<i; j++){
               if(s.charAt(i) == s.charAt(j)){
                   num = Math.min(num, i-j);
               }
            }
            answer[i] = num == 987654321 ? -1 : num;   
        }
        return answer;
    }
}