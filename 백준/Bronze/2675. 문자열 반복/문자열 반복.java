import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int R = sc.nextInt();
			String S = sc.next();
			
			for(int i=0; i<S.length(); i++) {
			System.out.print(String.valueOf(S.charAt(i)).repeat(R));	
			}
            System.out.println();
		} // tc

	} // main

}
