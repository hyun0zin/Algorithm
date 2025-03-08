class Solution {
    public int[] solution(int e, int[] starts) {
        int[] divisorCount = new int[e + 1]; // 각 숫자의 약수 개수 저장
        int[] maxValue = new int[e + 1];     // i 이상에서 가장 많이 등장한 수
        int[] maxCount = new int[e + 1];     // i 이상에서 가장 많이 등장한 수의 약수 개수

        // 1️⃣ 약수 개수 계산 (O(e log e))
        for (int i = 1; i <= e; i++) {
            for (int j = i; j <= e; j += i) {
                divisorCount[j]++;
            }
        }

        // 2️⃣ maxValue, maxCount 채우기 (O(e))
        int maxNum = e;
        maxValue[e] = e;
        maxCount[e] = divisorCount[e];

        for (int i = e - 1; i >= 1; i--) {
            if (divisorCount[i] >= maxCount[i + 1]) {
                maxCount[i] = divisorCount[i];
                maxValue[i] = i;
            } else {
                maxCount[i] = maxCount[i + 1];
                maxValue[i] = maxValue[i + 1];
            }
        }

        // 3️⃣ 정답 찾기 (O(1) per query)
        int[] result = new int[starts.length];
        for (int i = 0; i < starts.length; i++) {
            result[i] = maxValue[starts[i]];
        }
        
        return result;
    }
}