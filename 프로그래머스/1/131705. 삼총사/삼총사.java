class Solution {
    static int answer = 0;
    public int solution(int[] number) {
        comb(number, 0, 0, 0); 
        return answer;
    }
    
    static void comb(int[] number, int idx, int cnt, int sum){
        if(cnt == 3){
            if(sum == 0){
                answer++;
            }
            return;
        }
        
        for(int i=idx; i<number.length; i++){
            comb(number, i + 1, cnt + 1, sum + number[i]);
        }
    }
}