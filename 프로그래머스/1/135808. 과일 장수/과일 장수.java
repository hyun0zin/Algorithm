import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int appleCnt = score.length; 
        
        Arrays.sort(score);
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=appleCnt -1; i>=0; i--){
            queue.add(score[i]);
        }
        
        
        if(appleCnt < m) return 0;
        
        while(appleCnt >= m){
            int minScore = k;
            for(int i=0; i<m; i++){
                minScore = Math.min(k, queue.poll());
            }
            answer += (minScore * m);
            appleCnt -= m;
        }
        
        return answer;
    }
}