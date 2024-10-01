import java.util.Scanner;

// BOJ11726_2xn 타일링
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] dp = new int[N + 1];

		dp[1] = 1;

		// 1<= N <= 1,000 이므로 N이 1일 때 예외처리
		if (N > 1) {
			dp[2] = 2;
		}

		for (int i = 3; i <= N; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
		}

		System.out.println(dp[N]);

	}
}