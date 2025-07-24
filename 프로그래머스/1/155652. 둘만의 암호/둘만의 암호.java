import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        Set<Character> skipSet = new HashSet<>();
        for(char c : skip.toCharArray()){
            skipSet.add(c);
        }
        
        for(char ch : s.toCharArray()){
            int count = 0;
            char next = ch;
            
            while(count < index){
                next++;
                
                if(next > 'z') {
                    next = 'a';
                }
                
                if(!skipSet.contains(next)){
                    count++;
                } 
            }
            answer.append(next);     
            
        }
        return answer.toString();
    }
}