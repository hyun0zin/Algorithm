import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long N = sc.nextInt();
		long M = sc.nextInt();
		
		long diff = N-M;
		System.out.println(Math.abs(diff));
		
	}
}
