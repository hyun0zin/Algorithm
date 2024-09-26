import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// BOJ1926_그림
public class Main {
	static int N, M, cnt, maxSize, size;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int max = -1;

		cnt = 0;
		maxSize = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && arr[i][j] == 1) {
					size = 1;
					bfs(i, j);
					maxSize = Math.max(size, maxSize);

				}
			}

		}
		
		int ans = cnt == 0 ? 0 : cnt;
		System.out.println(ans);
		System.out.println(maxSize);
	}

	static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { r, c });
		visited[r][c] = true;

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int currR = curr[0];
			int currC = curr[1];

			for (int dir = 0; dir < 4; dir++) {
				int nr = currR + dr[dir];
				int nc = currC + dc[dir];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || arr[nr][nc] == 0)
					continue;

				visited[nr][nc] = true;
				queue.add(new int[] { nr, nc });
				size++;

			}
		} // while

		cnt++;
	}
}