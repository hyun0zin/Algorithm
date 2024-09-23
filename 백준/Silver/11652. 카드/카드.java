import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		long[] arr = new long[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextLong();
		}

		Arrays.sort(arr);

//		System.out.println(Arrays.toString(arr));

		int cnt = 1;
		int max = -1;
		long ans = arr[0]; // 첫 번째 값으로 초기화

		for (int i = 1; i < N; i++) {
			if (arr[i - 1] == arr[i]) {
				cnt++;

			} else {
				if (cnt > max) {
					// 최댓값 갱신
					max = cnt;
					ans = arr[i - 1];
				}

				cnt = 1; // cnt 값 초기화

			}
		}
		
		// 마지막 카드에 대한 처리
		if (cnt > max) {
			ans = arr[N - 1];
		}
		
		System.out.println(ans);

	}
}