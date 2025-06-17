import java.util.*;

class Solution {
    static int maxCount = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] isVisited = new boolean[dungeons.length];
        
        int answer = dfs(k, dungeons, isVisited, 0);
        
        return answer;
    }
    
    public int dfs(int k, int[][] dungeons,  boolean[] isVisited, int count){
        // 탐색할 수 있는 던전의 최대값
        maxCount = Math.max(maxCount, count);
        
        for(int i=0; i<dungeons.length; i++){
            int min = dungeons[i][0];
            int fatigue = dungeons[i][1];
            
            // k >= min : 던전의 최소 피로도보다 현재 피로도가 크면서 && 아직 방문하지 않은 던전이라면,
            if(k >= min && !isVisited[i]){
                isVisited[i] = true;
                dfs(k-fatigue, dungeons, isVisited, count+1);
                isVisited[i] = false;
            }
        }
        return maxCount;
    }
}