import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1463 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			if (i == 1) {
				dp[i] = 0;
			} else {
				dp[i] = dp[i - 1] + 1;
				if (i % 2 == 0) {
					dp[i] = Math.min(dp[i], dp[i/2]+1);
				}
				if (i % 3 == 0) {
					dp[i] = Math.min(dp[i], dp[i/3]+1);
				}
			}
		}
		System.out.println(dp[N]);

	}

}
