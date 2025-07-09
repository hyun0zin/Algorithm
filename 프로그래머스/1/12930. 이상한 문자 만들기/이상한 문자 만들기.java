class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int indexInWord = 0;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(c == ' '){
                // 공백을 만나면, 문장에서도 " " 공백 추가
                answer.append(" ");
                indexInWord = 0; // 새 단어 시작
            }else{
                if(indexInWord % 2 == 0){
                    answer.append(Character.toUpperCase(c));
                }else{
                    answer.append(Character.toLowerCase(c));
                }
                indexInWord++;
            }
        }
        return answer.toString();
    }
}