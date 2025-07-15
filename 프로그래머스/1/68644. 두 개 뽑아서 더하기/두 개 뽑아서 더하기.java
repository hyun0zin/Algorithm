import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
       
        Set<Integer> numSet = new HashSet<>();
        
        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length; j++){
                int num = numbers[i] + numbers[j];
                numSet.add(num); 
            }    
        }
        
        List<Integer> numList = new ArrayList(numSet);
        Collections.sort(numList);
        
        int[] answer = new int[numList.size()];
        for(int i=0; i<numList.size(); i++){
            answer[i] = numList.get(i);
        }
        
        return answer;
    }
}