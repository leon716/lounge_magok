import java.util.Scanner;

public class ALLERGY {

	static int min;
	static int N;
	static int M;
	static boolean isVisited[];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			min = Integer.MAX_VALUE;
			N = sc.nextInt();
			M = sc.nextInt();
			isVisited = new boolean[M];
			sc.nextLine();
			String[] names = sc.nextLine().split(" ");
			int[] foods = new int[M];
			for (int i = 0; i < M; i++) {
				String line = sc.nextLine();
				int canEatBit = bitMaskBuilder(names, line);
				foods[i] = canEatBit;
			}
			for (int i = 0; i < M; i++) {
				isVisited[i] = true;
				getMin(foods, 0, foods[i]);
				isVisited[i] = false;
			}
			System.out.println(min);
		}

	}

	public static void getMin(int[] foods, int foodCount, int allergyBit) {
		if (foodCount > min) {
			return;
		}
		if (allergyBit == 0) {
			if (foodCount < min) {
				min = foodCount;
			}
			return;
		}
		
		for (int i = 0; i < M; i++) {
			if (isVisited[i]) {
				continue;
			}
			isVisited[i] = true;
			getMin(foods, ++foodCount, allergyBit & foods[i]);
			isVisited[i] = false;


		}
		// System.out.println(allergyBit&foods[i]);
	}

	

	public static int bitMaskBuilder(String[] names, String line) {
		int result = (1 << N) - 1; // 사람 수만큼 1111... 생성
		// System.out.println(result);
		String[] temp = line.split(" ");
		// for(int i = 0 ; i < temp.length ; i++ ) {
		// System.out.print(temp[i]+" ");
		// }
		int numberOfNames = Integer.parseInt(temp[0]);
		for (int i = 1; i <= numberOfNames; i++) {
			for (int j = 0; j < names.length; j++) {
				if (temp[i].equals(names[j])) {
					result ^= 1 << j; // 해당 자리의 사람을 0으로 바꿈
				}
			}
		}
		// System.out.println(result);
		// System.out.println(~result);
		return result; // 첫번째 두번째 사람이 먹을 수 있으면 1100
	}

}
