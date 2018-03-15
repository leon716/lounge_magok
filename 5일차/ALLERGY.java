import java.util.Scanner;

public class ALLERGY {

	static int min;
	static int N;
	static int M;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			min = Integer.MAX_VALUE ;
			N = sc.nextInt();
			M = sc.nextInt();
			sc.nextLine();
			String[] names = sc.nextLine().split(" ");
			int[] foods = new int[M];
			for (int i = 0; i < M; i++) {
				String line = sc.nextLine();
				int canEatBit = bitMaskBuilder(names, line);
				foods[i] = canEatBit;
			}
			getMin(foods, 0, 1 , foods[0]);
			System.out.println(min);
		}

	}
	
	public static void getMin(int[] foods, int foodCount, int visitBit, int allergyBit) {
		if(foodCount>min) {
			return;
		}
		if(allergyBit==0) {
			if(foodCount<min) {
				min = foodCount;
			}
			return;
		}
		if(visitBit==(1<<N)-1) {
			return;
		}
		for(int i =0; i < M ; i++ ) {
			if((1<<i^visitBit)!=0) {
				continue;
			}
//			System.out.println(allergyBit&foods[i]);
			getMin(foods, ++foodCount, visitBit&1<<i , allergyBit&foods[i] );
		}
	}

	public static int bitMaskBuilder(String[] names, String line) {
		int result = (1 << N) - 1;
//		System.out.println(result);
		String[] temp = line.split(" ");
//		for(int i = 0 ; i < temp.length ; i++ ) {
//			System.out.print(temp[i]+" ");
//		}
		int numberOfNames = Integer.parseInt(temp[0]);
		for (int i = 1; i <= numberOfNames; i++) {
			for (int j = 0; j < names.length; j++) {
				if (temp[i].equals(names[j])) {
					result ^= 1 << j;
				}
			}
		}
//		System.out.println(result);
//		System.out.println(~result);
		return result;
	}

}
