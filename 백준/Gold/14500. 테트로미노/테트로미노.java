import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ14500_테트로미노
public class Main {
	static int N, M, ans;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(i, j, 1, arr[i][j]);
				visited[i][j] = false;
			}
		}
		System.out.println(ans);

	}

	// 1. ㅜ 모양을 제외한 모양으로 길이 4일때까지 4방 탐색 시작 => 그때 합이 최대인 값 도출
	// r,c : 현재 dfs가 시작하는 위치
	// length : dfs 진행한 길이
	// sum : 현재 시작하는 위치의 값
	static void dfs(int r, int c, int length, int sum) {
		if (length == 4) {
			ans = Math.max(ans, sum);
			return;
		}

		
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];

			if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc])
				continue;

			visited[nr][nc] = true;
			dfs(nr, nc, length + 1, sum + arr[nr][nc]);
			dfs(r, c, length + 1, sum + arr[nr][nc]); // ㅜ 모양 일때 계산하기
			visited[nr][nc] = false;
		}
		
	} // dfs

}