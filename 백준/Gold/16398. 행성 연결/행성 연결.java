import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// BOJ16398_행성연결
// 메모리 :
// 시간 :

public class Main {
	public static class Edge implements Comparable<Edge> {
		int A, B, W;

		public Edge(int a, int b, int w) {
			super();
			A = a;
			B = b;
			W = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.W, o.W);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 행성의 수
		int[][] adjArr = new int[N][N];

		// 행성 인접 행렬 입력 받기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				adjArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 인접 행렬 => 인접 리스트로 받아서 Edge에 저장해주기
		List<Edge>[] adjList = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				adjList[i].add(new Edge(i, j, adjArr[i][j]));
				adjList[j].add(new Edge(j, i, adjArr[i][j]));
			}
		}

		// 방문 체크
		boolean[] visited = new boolean[N]; // 방문한 정점인지 체크

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		visited[0] = true;

		long ans = 0;
		int pick = 1;

		pq.addAll(adjList[0]);

		// 모든 정점을 다 방문할 때까지 반복
		while (pick != N) {
			Edge e = pq.poll();

			// 이미 방문한 노드라면 pass
			if (visited[e.B])
				continue;

			// 방문하지 않은 노드라면 가중치 더하기
			ans += e.W;
			visited[e.B] = true;
			pick++;

			// 해당 노드와 연결된 노드 우선순위 큐에 넣기
			pq.addAll(adjList[e.B]);
		} // while

		System.out.println(ans);
	}
}