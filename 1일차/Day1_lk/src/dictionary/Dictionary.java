package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dictionary {
	
	static int target;
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("/Users/klee/workspace/eclipse/Day1/Data/dictionary.txt"));
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			String start = sc.next();
			String end = sc.next();
			target = sc.nextInt();
			int sLength = start.length();
			int eLength = end.length();
			
			int S = Integer.parseInt(start);
			
			System.out.println(cal(sLength, eLength, S));
		}
		sc.close();
	}
	
	public static int cal(int sl, int el, int s) {
		if(sl == el) {
			return s+target;
		} else {
			int diff = el-sl;
			
		}
		return 0;
	}
}
