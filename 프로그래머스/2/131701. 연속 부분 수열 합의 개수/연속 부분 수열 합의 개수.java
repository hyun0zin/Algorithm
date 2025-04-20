import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int n = elements.length;
        int[] doubleArr = new int[n * 2];

        // 원형 수열 구현을 위해 배열 크기를 2배로 만들기
        // [7,9,1,1,4,7,9,1,1,4]
        for(int i= 0; i < n; i++){
            doubleArr[i] = elements[i];
            doubleArr[i + n] = elements[i];
        }

        Set<Integer> sumSet = new HashSet<>();

        // 길이 1부터 n까지의 연속 부분 수열 합 계산
        for(int len=1; len<=n; len++){
            for(int i = 0; i<n; i++){
                int sum = 0;
                for(int j=i; j<i+len; j++){
                    sum += doubleArr[j];
                }
                sumSet.add(sum);
            }
        }
        
        answer = sumSet.size();

        return answer;
    }
}
