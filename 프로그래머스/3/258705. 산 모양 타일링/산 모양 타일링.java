class Solution {
    public int solution(int n, int[] tops) {
		int answer = 0;
		int[] a = new int[n + 1];
		int[] b = new int[n + 1];

		int mod = 10007;

		a[0] = 0;
		b[0] = 1;

		for (int i = 1; i <= n; ++i) {
			a[i] = (a[i - 1] + b[i - 1]) % mod;
			// tops가 1인 경우 
			if (tops[i - 1] > 0) {
				b[i] = (2 * a[i - 1] + 3 * b[i - 1]) % mod;
			// tops가 0인 경우 
			} else {
				b[i] = (a[i - 1] + 2 * b[i - 1]) % mod;
			}
		}

		answer = (a[n] + b[n]) % mod;
		return answer;
	}
}