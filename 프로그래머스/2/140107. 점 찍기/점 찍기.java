class Solution {
    public long solution(int k, int d) {
        long answer = 0;
            
        for(int a = 0; a*k <= d; a++){
                int maxB = (int)Math.sqrt((long)d*d - (long)(a*k)*(a*k)) / k; // b가 될 수 있는 최댓값
                // maxB = 2이면 -> (0, 0), (0, 2), (0, 4) 3개 가능
                answer+= maxB + 1;
        }
            
        
        return answer;
    }
}