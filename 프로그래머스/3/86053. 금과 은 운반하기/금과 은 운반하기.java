class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        // 트럭을 운반하는데 걸리는 최악의 시간
        // 필요시간 = 운반 횟수 * 왕복 시간
        // a와 b 각각 10^9개 필요 / 편도 최대 10^5 
        // (2 * 10^9) * (2 * 10^5) = 4 * 10^14 => Long 범위 안!!
        
        // 최소 시간 : 0, 최대 시간 : 4 * 10^14 충분히 큰 수로 정의
        long left = 0;
        long right = 4L * (long)1e14;
        long answer = right;
        
        // 이분 탐색으로 가능한 시간 찾기
        while(left <= right){
            long mid = (left + right) / 2;
            
            long totalGold = 0;
            long totalSilver = 0;
            long totalWeight = 0;
            
            // 각 도시의 트럭으로 mid 시간 동안 옮길 수 있는 광물 계산
            for(int i = 0; i<g.length; i++){
                long time = mid;
                long doubleTime = t[i] * 2L; // 왕복 시간 계산
                
                //mid 시간 동안 왕복 가능한 횟수
                long moveCnt = time / doubleTime;
                if(time % doubleTime >= t[i]){
                    // 마지막 편도 운반이 한 번 더 가능하면, 1회 추가
                    moveCnt += 1;
                }
                
                // mid 시간 내에 최대 운반 가능한 총 무게
                long maxWeight = moveCnt * w[i];
                
                long gold = Math.min(g[i], maxWeight);
                long silver = Math.min(s[i], maxWeight);
                long total = Math.min(g[i] + s[i], maxWeight);
                
                totalGold += gold;
                totalSilver += silver;
                totalWeight += total;
            }
            
            if(totalGold >= a && totalSilver >= b && totalWeight >= (a+b)){
                // 운반 가능 : 더 짧은 시간으로 운반 가능한지 확인
                answer = mid;
                right = mid - 1;
            } else {
                // 운반 불가능 : 더 긴 시간 찾기
                left = mid + 1;
            }
        }
        
        return answer;
    }
}