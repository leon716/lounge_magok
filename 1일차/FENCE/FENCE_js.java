import java.util.Scanner;

public class FENCE {
	
	private static int T;
	private static int[] fence;
	private static int index;
	private static int max;
	private static int width;

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int t = 0 ; t < T ; t++ ) {
			
			int result;
			max = Integer.MIN_VALUE;
			index = 0;
			width = sc.nextInt();
			fence = new int[width];
			
			for(int i = 0 ; i < width; i++ ) {
				fence[i] = sc.nextInt();
			}
			for(int i = 0 ; i < fence.length ; i++ ) {
				result = findMaxArea();
				index++;
				max = Integer.max(result, max);
			}
			System.out.println(max);


		}
		sc.close();
		
	}
	
	public static int findMaxArea() {
		int result = 0;
		
		if(index - 1 >= 0 || index + 1 < fence.length) {
			for(int i = index - 1 ; i >= 0 ; i --) {
				if(fence[index] <= fence[i]) {
					result += fence[index];
				} else {
					break;
				}
			}
			for(int i = index + 1 ; i < fence.length ; i++ ) {
				if(fence[index] <= fence[i]) {
					result += fence[index];
				} else {
					break;
				}

			}
			result += fence[index];
		}
		
		return result;
	}
	
	

}
