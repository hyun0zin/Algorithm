import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        int n = 0;
        
        Map<Integer, Integer> map = new HashMap();
        map.put(n, k);
        
        while(k > 1){       
            if(k % 2 == 0){
                k /= 2;
            }else {
                k = k * 3 + 1;
            }
            n++;
            map.put(n, k);
        }
        
        // System.out.println(map);
        
        for(int i = 0; i < ranges.length; i++){
            int start = ranges[i][0];
            int end = map.size() - 1 + ranges[i][1]; 
            
            // 시작점이 끝점보다 클 경우, -1
            if(start > end) {
                answer[i] = -1;
                continue;
            }
            
            double sum = 0;
            for(int j=start; j<end; j++){
                int lenA = map.get(j);
                int lenB = map.get(j+1);
                
                sum += (double) (lenA + lenB) / 2;
            }
            answer[i] = sum; 
        }
        
        return answer;
    }
    
}