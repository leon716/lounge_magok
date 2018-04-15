import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GRADUATION {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int[] preComplete = new int[N];
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());

				for (int i = 0; i < num; i++) {
					preComplete[n] |= (1 << Integer.parseInt(st.nextToken()));

				}
			}
			int[] classes = new int[M];
			int[] eachClass = new int[N];
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int classNum = Integer.parseInt(st.nextToken());
				for (int i = 0; i < classNum; i++) {
					int classIndex = Integer.parseInt(st.nextToken());
					eachClass[classIndex] |= (1 << m);
					classes[m] |= (1 << classIndex);
				}
			}
			int[][] memo = new int[M][1 << N];
			System.out.println(graduate(0, classes, preComplete, 0 ,N, K, M, L, memo));

		}

	}

	public static int graduate(int semester, int[] classes, int[] preComplete, int taken, int N, int K, int M, int L,
			int[][] memo) {
		if (Integer.bitCount(taken) >= K) {
			return 0;
		}
		if (semester == M) {
			return Integer.MAX_VALUE;
		}
		int result = memo[semester][taken];
		if (result != 0) {
			return result;
		}
		result = Integer.MAX_VALUE;
		int canTake = (classes[semester] & ~taken);
		for (int i = 0; i < N; N++) {
			if (((canTake & (1 << i)) & (taken & preComplete[i])) != preComplete[i]) {
				canTake &= ~(1 << i);
			}
		}
		for (int take = canTake; take > 0; take = ((take - 1) & canTake)) {
			if (Integer.bitCount(take) > L) {
				continue;
			}
			result = Math.min(result, graduate(semester + 1, classes, preComplete, taken | take, N, K, M, L, memo) + 1);
		}
		result = Math.min(result,  graduate(semester + 1, classes, preComplete, taken, N, K, M, L, memo) + 1);
		return result;
	}

}
