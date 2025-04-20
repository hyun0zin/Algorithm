import java.util.*;

class Solution {
    public int[] solution(int target) {
        // 처음 그리디로 위에서부터 큰 점수를 뺴는 식으로 접근 
        // -> 싱글 또는 불을 최대한 많이 던지는 방법 구하기 어려움
        
        // 가능한 다트 점수를 저장 / 0/1로 싱글, 불인지 구분
        List<int[]> scores = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            scores.add(new int[]{i, 1});       // 싱글
            scores.add(new int[]{i * 2, 0});   // 더블
            scores.add(new int[]{i * 3, 0});   // 트리플
        }

        scores.add(new int[]{50, 1}); // 불

        // dp[i] = i점을 만드는 데 필요한 최소 다트 수, 싱글 / 불 개수
        // [0] = 던진 횟수 , [1] = 싱글/불 횟수 저장
        int[][] dp = new int[target+1][2]; 
        for(int i = 1; i<= target; i++){
            dp[i][0] = Integer.MAX_VALUE; // 던진 횟수 초기화
            dp[i][1] = 0; // 싱글,불 갯수 초기화
        }
        
        for(int i=1; i<=target; i++){
            // 맞출 수 있는 scores를 돌면서 체크
            for(int[] s : scores){
                int score = s[0]; // 점수
                int isSingleOrBull = s[1]; // 싱글 또는 불인지 확인
                
                // i-score가 음수가 아니면서, 이전 점수가 유효한 경우만 진행
                if(i-score >=0 && dp[i-score][0] != Integer.MAX_VALUE){
                    // 이전 점수까지 필요한 다트 수 + 1
                    int darts = dp[i-score][0] + 1;
                    // 싱글/불 개수 갱신
                    int singleBull= dp[i-score][1] + isSingleOrBull;
                    
                    if(darts < dp[i][0]){
                        dp[i][0] = darts;
                        dp[i][1] = singleBull;
                    }else if( darts == dp[i][0] && singleBull > dp[i][1]){
                        dp[i][1] = singleBull;
                    }
                }
            }
            
            
        }
         return dp[target];   
}
}
