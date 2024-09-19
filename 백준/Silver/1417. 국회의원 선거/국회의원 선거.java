import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

// BOJ1417_국회의원 선거 
public class Main {
	static int N, cnt;
	static int[] voteNum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		voteNum = new int[N];

		for (int i = 0; i < N; i++) {
			voteNum[i] = sc.nextInt();
		}

		// 후보가 1명인 경우 매수할 필요가 없음
		if (N == 1) {
			System.out.println(0);
			return;
		}

		cnt = 0;
		// 우선 순위 큐를 활용 => 표가 많은 후보 먼저 나옴.
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 1; i < N; i++) {
			queue.add(voteNum[i]);

		}

		// 다솜이의 표가 다른 후보들보다 많아질 때까지 반복
		while (!queue.isEmpty() && queue.peek() >= voteNum[0]) {
			// 표가 가장 많은 후보의 표수를 가져옴
			int maxVotes = queue.poll();
			maxVotes--; // 그 후보의 표를 하나 줄이고
			voteNum[0]++; // 다솜이의 표를 하나 늘림
			cnt++; // 매수한 사람 수 증가
			queue.add(maxVotes); // 줄어든 표를 다시 pq에 넣음
		}
		System.out.println(cnt);
	}

}