import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// BOJ 1260 DFS와 BFS
public class Main {
	static int N, M, V, cnt;
	static int[][] adjArr;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();

		adjArr = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			adjArr[A][B] = adjArr[B][A] = 1;
		}

		cnt = 0;
		// DFS 진행
		dfs(V);

		// dfs 끝나고 모두 true로 바뀐 boolean 배열 초기화
		visited = new boolean[N + 1];

		System.out.println();
		
		bfs(V);
	}

	static void dfs(int start) {
//		if (cnt == N - 1)
//			return;

		visited[start] = true;
		System.out.print(start + " ");

		for (int i = 1; i < N + 1; i++) {
			if (!visited[i] && adjArr[start][i] == 1) {
				cnt++;
				dfs(i);

			}
		}

	}

	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();

		queue.add(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int currNum = queue.poll();
			System.out.print(currNum + " ");

			for (int i = 1; i < N + 1; i++) {
				if (!visited[i] && adjArr[currNum][i] == 1) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}

}