import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		long[] measureArray = new long[(int) N];

		for (int i = 0; i < N; i++) {
			measureArray[i] = sc.nextLong();
		}

		Arrays.sort(measureArray);

//		System.out.println(Arrays.toString(measureArray));
		long ans = measureArray[0] * measureArray[(int) N - 1];
		System.out.println(ans);

	}
}
