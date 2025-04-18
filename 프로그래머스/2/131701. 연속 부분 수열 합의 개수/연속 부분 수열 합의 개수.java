import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        int[] doubled = new int[n * 2];

        // 원형 수열 구현을 위해 배열 2배로 복사
        for (int i = 0; i < n * 2; i++) {
            doubled[i] = elements[i % n];
        }

        Set<Integer> sumSet = new HashSet<>();

        // 길이 1부터 n까지의 연속 부분 수열 합 계산
        for (int len = 1; len <= n; len++) {
            for (int start = 0; start < n; start++) {
                int sum = 0;
                for (int i = start; i < start + len; i++) {
                    sum += doubled[i];
                }
                sumSet.add(sum);
            }
        }

        return sumSet.size();
    }
}
