import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class Solution {

    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private int N;
    private int M;
    private int result = Integer.MAX_VALUE;

    public int solution(int[][] maze) {
        N = maze.length;
        M = maze[0].length;
        Point red = null;
        Point blue = null;
        int[][] visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maze[i][j] == 1) {
                    red = new Point(i, j);
                } else if (maze[i][j] == 2) {
                    blue = new Point(i, j);
                } else if (maze[i][j] == 3) {
                    maze[i][j] = 8;
                } else if (maze[i][j] == 4) {
                    maze[i][j] = 16;
                } else if (maze[i][j] == 5) {
                    maze[i][j] = 3;
                }
            }
        }
        move(red, blue, maze, 0);
        if (result == Integer.MAX_VALUE) {
            return 0;
        }
        return result;
    }

    private void move(Point red, Point blue, int[][] maze, int t) {
        if (maze[red.x][red.y] == 8 && maze[blue.x][blue.y] == 16) {
            result = Math.min(result, t);
            return;
        }

        for (Point r : next(1, red, maze)) {
            for (Point b : next(2, blue, maze)) {
                if (!r.equals(b) && (!r.equals(blue) || !b.equals(red))) {
                    if (maze[r.x][r.y] < 4) {
                        maze[r.x][r.y] += 1;
                    }
                    if (maze[b.x][b.y] < 4) {
                        maze[b.x][b.y] += 2;
                    }
                    move(r, b, maze, t + 1);
                    if (maze[r.x][r.y] < 4) {
                        maze[r.x][r.y] -= 1;
                    }
                    if (maze[b.x][b.y] < 4) {
                        maze[b.x][b.y] -= 2;
                    }
                }
            }
        }
    }

    private List<Point> next(int color, Point p, int[][] maze) {
        if (maze[p.x][p.y] >> 3 == color) {
            return List.of(p);
        }
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Point q = new Point(p.x + dx[i], p.y + dy[i]);
            if (q.x >= 0 && q.y >= 0 && q.x < N && q.y < M && (maze[q.x][q.y] & color) != color) {
                points.add(q);
            }
        }
        return points;
    }
}