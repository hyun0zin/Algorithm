import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        // Step 1: 구간을 종료 지점 기준으로 정렬
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));

        int answer = 0;
        double lastMissile = -1; // 마지막으로 요격 미사일을 발사한 위치

        for (int[] target : targets) {
            // Step 2: 현재 요격 미사일이 해당 구간을 커버하지 못하는 경우
            if (lastMissile < target[0]) {
                answer++; // 새로운 요격 미사일 추가
                lastMissile = target[1] - 0.5; // 개구간을 만족하기 위해 0.5 감소
            }
        }

        return answer;
    }
}
