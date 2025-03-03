import java.util.*;

class Solution {
    static class Node implements Comparable<Node> {
        int V, intensity;
        
        public Node(int V, int intensity) {
            this.V = V;
            this.intensity = intensity;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.intensity, o.intensity); // 최소 intensity 우선
        }
    }

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        // 1. 그래프 생성 (인접 리스트)
        List<Node>[] adjList = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 2. 간선 정보 추가 (양방향)
        for (int[] path : paths) {
            int A = path[0], B = path[1], W = path[2];
            adjList[A].add(new Node(B, W));
            adjList[B].add(new Node(A, W));
        }

        // 3. 출입구(Gates)와 산봉우리(Summits) 저장 (Set 활용)
        Set<Integer> gateSet = new HashSet<>();
        Set<Integer> summitSet = new HashSet<>();
        for (int gate : gates) gateSet.add(gate);
        for (int summit : summits) summitSet.add(summit);

        // 4. 다익스트라 알고리즘 실행
        int[] minIntensity = new int[n + 1]; // 최소 intensity 저장
        Arrays.fill(minIntensity, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n + 1];

        // 모든 출입구에서 시작
        for (int gate : gates) {
            minIntensity[gate] = 0;
            pq.add(new Node(gate, 0));
        }

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int now = cur.V;
            int intensity = cur.intensity;

            // ✅ 방문한 적 있으면 스킵 (PriorityQueue에서 중복 제거)
            if (visited[now]) continue;
            visited[now] = true;

            // ✅ 현재 위치가 산봉우리라면 탐색 중단
            if (summitSet.contains(now)) continue;

            // ✅ 인접한 노드 탐색 (산봉우리는 탐색하지 않음)
            for (Node next : adjList[now]) {
                if (gateSet.contains(next.V)) continue; // 출입구는 다시 방문하지 않음

                int nextIntensity = Math.max(intensity, next.intensity);

                // ✅ 최소 intensity 갱신 (산봉우리를 PriorityQueue에 추가하지 않음)
                if (nextIntensity < minIntensity[next.V]) {
                    minIntensity[next.V] = nextIntensity;
                    pq.add(new Node(next.V, nextIntensity));
                }
            }
        }

        // 5. 최소 intensity를 가지는 산봉우리 찾기
        Arrays.sort(summits); // 같은 intensity일 경우 번호가 작은 산봉우리 선택
        int minSummit = -1, minValue = Integer.MAX_VALUE;
        for (int summit : summits) {
            if (minIntensity[summit] < minValue) {
                minValue = minIntensity[summit];
                minSummit = summit;
            }
        }

        return new int[]{minSummit, minValue};
    }
}
