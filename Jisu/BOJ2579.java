import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2579 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] stair = new int[N];
		int[] dp = new int[N];

		for (int n = 0; n < N; n++) {
			stair[n] = Integer.parseInt(br.readLine());
		}
		for (int n = 0; n < N; n++) {
			if (n == 0) {
				dp[n] = stair[n];
			} else if (n == 1) {
				dp[n] = Math.max(stair[n] + stair[n - 1], stair[1]);
			} else if (n == 2) {
				dp[n] = Math.max(stair[n] + stair[n - 2], stair[n - 1] + stair[n]);
			} else {
				dp[n] = Math.max(dp[n - 3] + stair[n - 1] + stair[n], dp[n - 2]  + stair[n]);
			
			}
		}
		System.out.println(dp[N - 1]);

	}

}
