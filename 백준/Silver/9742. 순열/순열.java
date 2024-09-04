import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

// BOJ9742_순열
public class Main {
	static char[] arr;
	static char[] result;
	static boolean[] visited;

//	static List<String> list = new ArrayList<>();

	static int N;
	static int ansIdx, count;
	static String ansStr;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputLine;

		while ((inputLine = br.readLine()) != null && !inputLine.trim().isEmpty()) {
			StringTokenizer st = new StringTokenizer(inputLine);

			if (st.countTokens() < 2) { // 토큰의 개수가 2개 이상인지 체크
				continue; // 토큰이 부족하면 다음 입력을 받음
			}

			String str = st.nextToken();
			ansIdx = Integer.parseInt(st.nextToken());

			N = str.length();
			arr = new char[N];
			result = new char[N];
			visited = new boolean[N];

			for (int i = 0; i < str.length(); i++) {
				arr[i] = str.charAt(i);
			}
//			list.clear();

//			System.out.println(Arrays.toString(arr));
			count = 0;
			sb.append(str).append(" ").append(ansIdx).append(" = ");
			perm(0, 0);

//			String ans;
//			if (ansIdx - 1 > list.size()) {
//				ans = "No permutaion";
//			} else {
//				ans = list.get(ansIdx - 1);
//			}

//			sb.append(str).append(" ").append(ansIdx).append(" = ").append(ans).append("\n");
			
//			System.out.printf("%s %d = %s\n ", str, ansIdx, ans);
			
			if(ansIdx > count) {
				sb.append("No permutation" ).append("\n");
			}

		} // tc
		System.out.println(sb.toString());
	} // main

	static void perm(int idx, int cnt) {

		if (cnt == N) {
//			ansStr = "";
//			for (char a : result) {
//				ansStr += a; // 새로운 문자열을 계속해서 추가하고 있기 때문에 메모리 사용 많아짐 => sb에 바로바로 추가하기
//			}
//			System.out.println(ansStr);
			count++;
//			System.out.println(count);
			if (count == ansIdx) {
				sb.append(result).append("\n");
//				System.out.println(ansStr);
				return;
			} 
//			list.add(ansStr);
			return;
		}

		// list에 담긴 값이 ansIdx랑 같으면 return
//		if (list.size() == ansIdx) {
////			System.out.println(list);
//			return;
//		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;

			result[cnt] = arr[i];
			visited[i] = true;
			perm(i, cnt + 1);
			visited[i] = false;

		}
	}
}