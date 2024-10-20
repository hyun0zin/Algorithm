import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// BOJ2839_설탕 배달 
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine()); // 배달해야 하는 총 설탕 무게

		int fiveCnt = 0;
		int threeCnt = 0;
		int x = total;

		total = (5 * fiveCnt) + (3 * threeCnt) + x;

		// 나머지가 0이 될 때 stop
		fiveCnt = total / 5;

		while (fiveCnt >= 0) {
			threeCnt = (total - (5 * fiveCnt)) / 3;

			x = total - ((5 * fiveCnt) + (3 * threeCnt));

			if (x != 0) {
				fiveCnt--;
			} else {
				break;
			}
		} // while

		if (fiveCnt < 0) {
			System.out.println(-1);
		} else {
			System.out.println(fiveCnt + threeCnt);
		}

	}
}