import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int minLevel = 1; // diffs[0] = 1이므로
        int maxLevel = -1;
        for(int i=0; i<diffs.length; i++){
            maxLevel = Math.max(maxLevel, diffs[i]);
        }
        
        // 이진 탐색 시작 
        while(minLevel <= maxLevel){    
            // level은 중간값(mid)부터 시작 
            int mid = (minLevel + maxLevel) / 2;            
           
           if(canComplete(diffs, times, limit, mid)){
               // 시간 내 해결 가능하다면
               // 더 낮은 레벨 탐색 == 최솟값 찾기
               answer = mid;
               maxLevel  = mid -1;
           }else {
               // 시간 내 해결하지 못한다면,
               minLevel = mid + 1;
           }
        }
        
        return answer;
    }
    
    public static boolean canComplete(int[] diffs, int[] times, long limit, int mid){
         int level = mid;
        
         for(int i=0; i<diffs.length; i++){
                if(diffs[i] <= level) {
                    limit -= times[i];
                }else {
                    int errorCnt = diffs[i] - level;
                    int time = (times[i-1] + times[i])*errorCnt + times[i];
                    limit -= (long) time;
                }  
                
                if(limit < 0){
                    return false; // 제한 시간 초과
                }
            }
        return true; // 제한 시간은 통과
    }
}