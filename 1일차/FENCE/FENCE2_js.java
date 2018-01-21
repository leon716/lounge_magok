import java.util.Scanner;

public class FENCE2 {

	private static int T;
	private static int width;
	private static int[] fence;
	private static int max;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int t = 0 ; t < T ; t++ ) {
			
			width = sc.nextInt();
			fence = new int[width];
			max = Integer.MIN_VALUE;
			for(int i = 0 ; i < width; i++ ) {
				fence[i] = sc.nextInt();
			}
			max = findMaxArea(0, width-1);
			
			System.out.println(max);


		}
		sc.close();

	}
	
	public static int findMaxArea(int left, int right) {
		
		if(left == right) {
			return fence[left];
		}
		
		int mid = (left + right) / 2;
		
		int answer = Math.max(findMaxArea(left, mid), findMaxArea(mid+1, right));
		
		int lo = mid;
		int hi = mid + 1;
		int height = Math.min(fence[lo], fence[hi]);
		
		answer = Math.max(answer, height*2);
		
		while(left < lo || hi < right) {
			if(hi < right && (lo == left || fence[lo-1] < fence[hi+1])) {
				hi++;
				height = Math.min(height, fence[hi]);
				
			}
			else {
				lo--;
				height = Math.min(height, fence[lo]);
			}
			answer = Math.max(answer, height * (hi - lo + 1));
		}
		
		return answer;
	}

}
