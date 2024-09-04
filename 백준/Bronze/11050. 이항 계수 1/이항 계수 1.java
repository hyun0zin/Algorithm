import java.util.Scanner;

// BOJ11050_이항계수1
// 이항 계수 (N K) => nCk => 조합 구하기
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		int top = 1;
		for (int i = N; i > N - K; i--) {
			top *= i;
		}
//		System.out.println(top);

		int bottom = 1;
		for(int i=K; i>0; i--) {
			bottom *= i;
		}
		
//		System.out.println(bottom);
		
		System.out.println(top / bottom);
	}
}