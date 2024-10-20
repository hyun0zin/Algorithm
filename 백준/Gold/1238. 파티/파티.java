import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 다익스트라 알고리즘 
public class Main {
	public static class Edge implements Comparable<Edge> {
		int N, W;

		public Edge(int n, int w) {
			super();
			N = n;
			W = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.W - o.W;
		}
	}

	static final int INF = Integer.MAX_VALUE;
	static int N, M, X;
	static List<Edge>[] adjList; // 한 마을에서 연결된 마을
	static int[] distBack, distGo; // 거리 배열 == 가중치 저장
	static int goMin, backMin, ans; // 가는게 걸리는 최단 거리

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 마을의 수
		M = Integer.parseInt(st.nextToken()); // 단방향 도로의 수
		X = Integer.parseInt(st.nextToken()); // 파티를 하는 마을의 번호 == 도착해야할 지점

		adjList = new ArrayList[N + 1]; // 마을의 번호가 1부터

		for (int i = 1; i < N + 1; i++) {
			adjList[i] = new ArrayList();
		}

		distBack = new int[N + 1];
		distGo = new int[N + 1];
		Arrays.fill(distBack, INF);
		Arrays.fill(distGo, INF);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			adjList[A].add(new Edge(B, W)); // 단방향 도로이므로
		}

		// X 마을에서 파티가 끝나고 돌아가는 길 최솟값
		backDijkstra(X); // i번 마을 다익스트라 진행

		// X 마을까지 가는 최단 거리
		for (int i = 1; i < N + 1; i++) {
			if (i == X)
				continue;
			
			// 각 마을에서 출발할 때 distGo 배열 초기화 
			Arrays.fill(distGo, INF);

			goMin = goDijkstra(i); // 각 마을에서 파티 장소까지 다익스트라
			backMin = distBack[i];

			// 해당 마을에서 X로 갈 수 있을 때만 계산 
			if(goMin != -1) {
				ans = Math.max(ans, goMin + backMin);
			}
		}

		System.out.println(ans);

	}

	// 파티 장소로 갈 때 최소 거리 구하기
	static int goDijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] visitedGo = new boolean[N + 1];

		distGo[start] = 0;

		pq.add(new Edge(start, 0));

		while (!pq.isEmpty()) {
			Edge e = pq.poll();

			if (e.N == X)
				return e.W;

			if (visitedGo[e.N])
				continue; // 이미 방문 했다면 해당 지점까지의 비용을 알고 있다.
			visitedGo[e.N] = true;

			for (Edge node : adjList[e.N]) {
				if (distGo[node.N] > distGo[e.N] + node.W) {
					distGo[node.N] = distGo[e.N] + node.W;

					pq.add(new Edge(node.N, distGo[node.N]));
				}
			}

		}
		return -1;
	}

	static void backDijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N + 1];

		distBack[start] = 0; // 출발하는 지점의 가중치 = 0으로 두고 비교 시작

		pq.add(new Edge(start, 0));

		while (!pq.isEmpty()) {
			Edge e = pq.poll();

			if (visited[e.N])
				continue; // 이미 방문 했다면 해당 지점까지의 비용을 알고 있다.
			visited[e.N] = true;

			for (Edge node : adjList[e.N]) {
				if (distBack[node.N] > distBack[e.N] + node.W) {
					distBack[node.N] = distBack[e.N] + node.W;

					pq.add(new Edge(node.N, distBack[node.N]));
				}
			}

		}

	}
}