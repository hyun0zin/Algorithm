import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int T = sc.nextInt();
		int[] numArray = new int[N];
		int ans;

		for (int i = 0; i < N; i++) {
			numArray[i] = sc.nextInt();
		}

		for (int j = 0; j < N; j++) {
			if (numArray[j] < T) {
				ans = numArray[j];
				System.out.println(ans);
			}

		}

	}
}
