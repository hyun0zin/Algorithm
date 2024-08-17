import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char[] charArr = new char[str.length()];
		int[] alphabetArr = new int[26];
		for (int i = 0; i < 26; i++) {
			alphabetArr[i] = -1;
		}

		for (int i = 0; i < str.length(); i++) {
			charArr[i] = str.charAt(i);
			int num = (str.charAt(i) - '0') - 49;
			if (alphabetArr[num] == -1) {
				alphabetArr[num] = i;
			}
		}

		for (int a : alphabetArr) {
			System.out.print(a + " ");
		}
	}
}
