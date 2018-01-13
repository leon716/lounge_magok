import java.util.Scanner;

public class FENCE {
	
	private static int T;
	private static String[] fence;
	private static int index;
	private static int max;

	public static void main(String[] args) {
		
		String temp;
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		sc.nextLine();
		
		for(int t = 0 ; t < T ; t++ ) {
			
			int result;
			temp = sc.nextLine();
			max = Integer.MIN_VALUE;
			index = 0;
			temp = sc.nextLine();
			fence = temp.split(" ");
			
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
				if(Integer.parseInt(fence[index]) <= Integer.parseInt(fence[i])) {
					result += Integer.parseInt(fence[index]);
				} else {
					break;
				}
			}
			for(int i = index + 1 ; i < fence.length ; i++ ) {
				if(Integer.parseInt(fence[index]) <= Integer.parseInt(fence[i])) {
					result += Integer.parseInt(fence[index]);
				} else {
					break;
				}

			}
			result += Integer.parseInt(fence[index]);
		}
		
		return result;
	}
	
	

}
