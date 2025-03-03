import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int INF = Integer.MAX_VALUE;
        
        // 1. 목표 지점 찾기
        int max_alp = 0, max_cop = 0;
        for (int[] p : problems) {
            max_alp = Math.max(max_alp, p[0]); // 가장 높은 알고력 요구
            max_cop = Math.max(max_cop, p[1]); // 가장 높은 코딩력 요구
        }
        
        // 현재 alp, cop가 목표보다 크다면, 제한할 필요가 없음.
        alp = Math.min(alp, max_alp);
        cop = Math.min(cop, max_cop);

        // 2. DP 배열 초기화
        int[][] dp = new int[max_alp + 1][max_cop + 1];
        for (int[] row : dp) Arrays.fill(row, INF);
        
        // 3. 초기값 설정 (현재 alp, cop에서 시작)
        dp[alp][cop] = 0;
        
        // 4. DP 테이블 갱신 (BFS 방식으로 최적 경로 탐색)
        for (int i = alp; i <= max_alp; i++) {
            for (int j = cop; j <= max_cop; j++) {
                if (i < max_alp) dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1); // 알고력 +1
                if (j < max_cop) dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1); // 코딩력 +1
                
                for (int[] p : problems) {
                    if (i >= p[0] && j >= p[1]) { // 문제를 풀 수 있는 경우
                        int ni = Math.min(i + p[2], max_alp);
                        int nj = Math.min(j + p[3], max_cop);
                        dp[ni][nj] = Math.min(dp[ni][nj], dp[i][j] + p[4]);
                    }
                }
            }
        }
        
        // 5. 목표 지점 (max_alp, max_cop) 도달하는 최소 시간 반환
        return dp[max_alp][max_cop];
    }
}
