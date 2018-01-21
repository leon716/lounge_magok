package fence;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Fence {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("/Users/klee/workspace/eclipse/Day1/Data/fence.txt"));
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			int N = sc.nextInt();
			int[] num = new int[N];
			for (int j=0; j<N; j++)
				num[j]=sc.nextInt();
			h = num;
			System.out.println(solve(0,h.length-1));
//			System.out.println(bruteForce(num));
		}
		sc.close();
	}
	
	public static int bruteForce(int[] num) {
		int ret = 0;
		int N = num.length;
		
		for(int left=0; left<N; ++left) {
			int minHeight = num[left];
			for(int right = left; right<N; ++right) {
				minHeight = Integer.min(minHeight, num[right]);
				ret = Integer.max(ret, (right-left+1)*minHeight);
			}
		}
		return ret;
	}
	
	static int[] h;
	
	public static int solve(int left, int right) {
		if(left == right) return h[left];
		int mid = (left+right)/2;
		int ret = Integer.max(solve(left,mid), solve(mid+1,right));
		int lo = mid, hi = mid+1;
		int height = Integer.min(h[lo], h[hi]);
		ret = Integer.max(ret, height*2);
		
		while(left < lo || hi < right) {
			if(hi < right && (lo == left || h[lo-1] < h[hi+1])) {
				++hi;
				height = Integer.min(height,h[hi]);
			} else {
				--lo;
				height = Integer.min(height, h[lo]);
			}
			ret = Integer.max(ret, height*(hi-lo+1));
		}
		return ret;
	}
}
