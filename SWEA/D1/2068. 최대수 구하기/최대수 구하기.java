import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int max = -1;
			for (int i = 0; i < 10; i++) {
				max = Math.max(max, sc.nextInt());
			}
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		} // tc
		System.out.println(sb.toString());
	} // main
}
