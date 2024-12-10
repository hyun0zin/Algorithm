import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/* BOJ16234_인구이동
시간 : 
메모리 : 
*
*/

public class Main {
	static int N, L, R;
	static int[][] board;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static List<Node> list;

	public static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		 N = Integer.parseInt(st.nextToken());
		 L = Integer.parseInt(st.nextToken());
		 R = Integer.parseInt(st.nextToken());

		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int ans = 0; // 정답

		// 더이상 인구 이동이 일어나지 않을때까지 반복
		while (true) {
			boolean isMove = false;
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {

						int totalSum = bfs(i, j); // 인구 이동할 총 인원
						int NodeNum = list.size(); // 인구 이동 할 수 있는 모든 노드 수
						int avg = totalSum / NodeNum; // 인구 이동 후, 각 노드별 인구 수

						// list 내의 모든 Node를 돌면서, 새로운 인구로 바꾸기
						if (list.size() > 1) {
							for (Node n : list) {
								board[n.x][n.y] = avg;
							}
							isMove = true; // 인구 이동 계속 진행함
						}
					}
				}
			}

			// 더이상 인구 이동을 진행하지 않으면,
			if (!isMove) {
				System.out.println(ans); // 답 출력
				break; // 무한루프 빠져나가기
			}

			// 인구이동이 계속 가능하다면, ans ++ 해주기
			ans++;
		}

	}

	static int bfs(int r, int c) {
		Queue<Node> queue = new LinkedList<>();
		list = new ArrayList<>();

		queue.add(new Node(r, c)); // bfs 돌면서 이동 가능한 Node queue에 넣기
		list.add(new Node(r, c)); // 인구 이동할 Node 몇 개인지 -> list에 추가
		visited[r][c] = true;
		int sum = board[r][c];

		while (!queue.isEmpty()) {
			Node curr = queue.poll();

			for (int dir = 0; dir < 4; dir++) {
				int nr = curr.x + dr[dir];
				int nc = curr.y + dc[dir];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc])
					continue;

				int diff = Math.abs(board[nr][nc] - board[curr.x][curr.y]);
				if (L <= diff && diff <= R) {
					queue.add(new Node(nr, nc));
					list.add(new Node(nr, nc));
					sum += board[nr][nc];
					visited[nr][nc] = true;
				}
			}

		}
		return sum; // 인구이동 할 수 있는 모든 Node의 사람 수
	}

}