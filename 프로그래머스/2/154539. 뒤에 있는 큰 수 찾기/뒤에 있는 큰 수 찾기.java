import java.util.*;

// 완탐 시, O(N^2) => 시간 초과!
class Solution {
    public int[] solution(int[] numbers) {
        int N = numbers.length;
        int[] answer = new int[N];
        Arrays.fill(answer, -1); // 모든 값을 -1로 초기화
        
        Stack<Integer> stack = new Stack<>();
        
        stack.push(0); // 첫 번째 인덱스 스택에 넣기
        
        for(int i=1; i<N; i++){
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]){
                answer[stack.pop()] = numbers[i];
            }
             stack.add(i);
        }
        
        
        return answer;
    }
}