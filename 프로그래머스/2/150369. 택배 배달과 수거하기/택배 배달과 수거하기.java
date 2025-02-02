class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
		long answer = 0; // 총 이동거리
        
        int deliver = 0; // 현재 배달해야 하는 택배 수
        int pickup = 0; // 현재 수거할 택배 수
        
        // 가장 먼집부터 순회
        for(int i=n-1; i>=0; i--){
          
            deliver += deliveries[i];
            pickup += pickups[i];
            
            // 현재 배달 또는 수거할 택배가 남아 있는 동안 계속 반복
            while(deliver > 0 || pickup > 0){
                // 트럭 용량 만큼 배달 또는 수거
                deliver -= cap;
                pickup -= cap;
                
                // 왕복 거리 계산
                answer += (i + 1) *2;
            }
        }
		return answer;
	}

}