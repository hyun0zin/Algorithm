class Solution {
    static String[] vowels = {"A", "E", "I", "O", "U"};
    static int count = 0;
    static int answer = 0;
    
    public int solution(String word) {
        // 1자리 => 5^1
        // 2자리 => 5^2
        // 3자리 => 5^3
        // 4자리 => 5^4
        // 5자리 => 5^5
        // 총 5(1+5+5^2+5^3+5^4) = 5(1+5+25+125+625) = 5(781)=3905개 => 완탐 가능
        // A AA AAA AAAA AAAAA AAAAE AAAAI AAAAO AAAAU AAAE
        // dfs 돌면서 순서 반환 => 완전탐색
        
        dfs("", word);
        return answer;
    }
    
    public static void dfs(String current, String word){
        if(current.length() > 5){
            return;
        }
        
        count++;
        
        // 현재 string이 target한 단어랑 같으면, return
        if(current.equals(word)){
            answer = count-1;
            return;
        }
        
        // 현재 String이 주어진 word랑 다르면,
        for(String v : vowels){
            dfs(current + v, word);
        }
    }
}