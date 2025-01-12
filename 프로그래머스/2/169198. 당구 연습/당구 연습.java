class Solution {
   public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
		int[] answer = new int[balls.length];

		for (int i = 0; i < balls.length; i++) {
			int targetX = balls[i][0];
			int targetY = balls[i][1];

			int dist = 0;
			int result = Integer.MAX_VALUE;

			// 좌
			if (!(startY == targetY && startX >= targetX)) {
				dist = calc(startX, startY, targetX * (-1), targetY);
				result = Math.min(result, dist);
			}

			// 우
			if (!(startY == targetY && startX <= targetX)) {
				dist = calc(startX, startY, targetX + 2 * (m - targetX), targetY);
				result = Math.min(result, dist);
			}

			// 상
			if (!(startX == targetX && startY <= targetY)) {
				dist = calc(startX, startY, targetX, targetY + 2 * (n - targetY));
				result = Math.min(result, dist);
			}

			// 하
			if (!(startX == targetX && startY >= targetY)) {
				dist = calc(startX, startY, targetX, targetY * (-1));
				result = Math.min(result, dist);
			}

			answer[i] = result;

		}
		return answer;
	}

	static int calc(int startX, int startY, int targetX, int targetY) {
		return (int) (Math.pow(startX - (targetX), 2) + Math.pow(startY - (targetY), 2));
	}
}