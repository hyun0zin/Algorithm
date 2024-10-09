import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ14502_연구소 
public class Main {
    static int N, M, ans;
    static int[][] map;
    static int[][] copyMap ; // map 복사본
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    // 조합 사용
    static List<Pos> list;
    static Pos[] result;

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        copyMap = new int[N][M];
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    list.add(new Pos(i, j)); // 빈 칸 list에 추가
                }
            }
        }

        // 빈 칸 위치들 중 3개 벽 뽑기 => 조합 돌리기 => 바이러스 퍼뜨리기
        result = new Pos[3]; // 벽은 항상 3개니까 크기를 3으로
        ans = 0;
        combi(0, 0);

        System.out.println(ans);
    }

    // 빈 칸 0인 위치 중 3개 조합 구하기
    static void combi(int idx, int cnt) {
        if (cnt == 3) {
            // 3개의 빈칸을 벽으로 세운 후 바이러스 퍼뜨리기
           
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    copyMap[i][j] = map[i][j]; // 현재 map 복사
                }
            }

            for (Pos p : result) {
                copyMap[p.x][p.y] = 1; // 벽으로 만들기
            }

            // 바이러스 퍼뜨리기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (copyMap[i][j] == 2) {
                        bfs(i, j, copyMap); //복사한 맵에 대해 bfs 수행
                    }
                }
            }

            // 안전 구역 계산
            int safeCnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (copyMap[i][j] == 0) {
                        safeCnt++;
                    }
                }
            }

            // 최댓값 갱신
            ans = Math.max(ans, safeCnt);
            return;
        }

        // 조합 구하기 
        for (int i = idx; i < list.size(); i++) {
            result[cnt] = list.get(i); //i번째 위치 result 배열에 넣기 
            combi(i + 1, cnt + 1);
        }
    }

    static void bfs(int r, int c, int[][] map) {
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(r, c));

        while (!queue.isEmpty()) {
            Pos currPos = queue.poll();
            int currR = currPos.x;
            int currC = currPos.y;

            for (int dir = 0; dir < 4; dir++) {
                int nr = currR + dr[dir];
                int nc = currC + dc[dir];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                    continue;
                }

                if (map[nr][nc] == 0) {
                    map[nr][nc] = 2; // 바이러스 전파
                    queue.add(new Pos(nr, nc));
                }
            }
        }
    }
}