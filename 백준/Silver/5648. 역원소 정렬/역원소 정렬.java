import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// BOJ5648_역원소 정렬
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Long> list = new ArrayList<>();

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			String str = sc.next();
			String newStr = "";
			for (int j = str.length() - 1; j >= 0; j--) {
				newStr += str.charAt(j);
			}

			long num = Long.parseLong(newStr);
			list.add(num);
		}

		Collections.sort(list);

		for (long ans : list) {
			System.out.println(ans);
		}

	}
}