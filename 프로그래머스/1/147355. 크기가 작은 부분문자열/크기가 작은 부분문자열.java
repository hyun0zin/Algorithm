class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        int pLen = p.length();
        
        for(int i=0; i < t.length() - pLen + 1; i++){
            String newStr = t.substring(i, i+pLen);
            
            if(newStr.compareTo(p) <= 0){
                answer++;
            }
        }
        return answer;
    }
}