
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Stack<Character> stack = new Stack<>();
		String str = sc.next();
		// 막대기
		int count = 0;
		int result = 0;
		for (int s = 0; s < str.length(); s++) {
			// 큐가 비어있으면 무조건 넣기
			if (stack.isEmpty()) {
				stack.push(str.charAt(s));
			}
			// ()이면 ) 넣지 않고 (도 같이 데리고 나가기
			else if (stack.peek() == '(' && str.charAt(s) == ')' && str.charAt(s - 1) == '(') {
				stack.pop();
				result += count;
			}
			// ( 이면 막대기 플러스 1
			else if (str.charAt(s) == '(' && str.charAt(s - 1) == ')') {
				stack.push(str.charAt(s));
			} else if (str.charAt(s) == '(') {
				stack.push(str.charAt(s));
				count++;
			} else if (str.charAt(s) == ')') {
				stack.push(str.charAt(s));
				count--;
				result++;
			}

		}
		System.out.println(result);

	} // main
} // class
