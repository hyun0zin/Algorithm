import java.util.*;

class Solution {
   static int[][] section;

	public int solution(int[] picks, String[] minerals) {
		int diaCnt = picks[0]; // 다이아 곡괭이 갯수
		int ironCnt = picks[1]; // 철 곡괭이 갯수
		int stoneCnt = picks[2]; // 돌 곡괭이 갯수

		int totalMineralNum = minerals.length;

//		System.out.println(totalMineralNum);

		int answer = 0;
		int pickCnt = diaCnt + ironCnt + stoneCnt; // 곡괭이 총 갯수

		int cnt = Math.min(totalMineralNum / 5 + 1, pickCnt);
		section = new int[cnt][3]; // 5개씩 묶었을 때, 광물의 피로도 계산

		int dp = 0, ip = 0, sp = 0;

		// 곡괭이 수 반복 -> 곡괭이 수가 부족하면 나머지 광물은 못 캠
		for (int i = 0; i < totalMineralNum; i += 5) {
			if (i / 5 == cnt)
				break;

			for (int j = i; j < i + 5; j++) {
				if (minerals[j].equals("diamond")) {
					dp += 1;
					ip += 5;
					sp += 25;
				} else if (minerals[j].equals("iron")) {
					dp += 1;
					ip += 1;
					sp += 5;
				} else {
					dp += 1;
					ip += 1;
					sp += 1;
				}
				if (j == totalMineralNum - 1) {
					break;
				}
			}

			section[i / 5][0] = dp;
			section[i / 5][1] = ip;
			section[i / 5][2] = sp;

			dp = ip = sp = 0;
		}

		Arrays.sort(section, (o1, o2) -> (o2[2] - o1[2]));

		for (int i = 0; i < cnt; i++) {
			if (diaCnt != 0) {
				answer += section[i][0]; // 다이아로 깼을 때의 피로도
				diaCnt--; // 다이어 곡괭이 갯수 --
			} else if (ironCnt != 0) {
				answer += section[i][1]; // 철로 깼을 때의 피로도
				ironCnt--; // 철 곡괭이 갯수 --
			} else if (stoneCnt != 0) {
				answer += section[i][2]; // 돌로 깼을 때의 피로도
				stoneCnt--; // 돌 곡괭이 갯수 --
			}
		}

		return answer;
	}
}