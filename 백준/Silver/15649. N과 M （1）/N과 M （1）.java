
import java.util.Scanner;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] selected;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		visited = new boolean[N]; // 방문 여부 체크
		selected = new int[M]; // 경우의 수 배열 
		
		select(0, 0);
		System.out.println(sb);
	}
	
	static void select(int idx, int count) {
		if(count == M) { // M개 고르면 출력 
			for(int i = 0; i < M; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < N; i++) { // N까지 
			if(!visited[i]) { // visited 이용해서 중복 체크
				visited[i] = true; 
				selected[count] = i+1; 
				select(i, count+1);
				visited[i] = false;
			}
		}
	}
	
}
