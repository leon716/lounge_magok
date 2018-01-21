package quadtree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuadTree {
	public static void main(String[] args) throws FileNotFoundException {
			Scanner sc = new Scanner(new File("/Users/klee/workspace/eclipse/Day1/Data/quadtree.txt"));
			int testCase = sc.nextInt();
			
			for(int i=0; i<testCase; i++) {
				String a = xNode(sc.next());
				System.out.println(a);
			}
	}
	
	public static String xNode(String node) {
		if(!node.contains("x"))
			return node;
		else {
			int x = node.indexOf("x");
			String split = node.substring(x+1);
			int xx = split.indexOf("x");
			if (xx<0) 
				swap(split);
			
			else if ((split.indexOf("x", xx+1)-xx)>3)
				return swap(split) +xNode(split.substring(xx+4));
//			System.out.println(xx);
			return node.substring(0, x+1) + xNode(split);
		}
	}
	
	public static String swap(String split) {
		if (split.length() == 4)
			return "x"+split.substring(2,3)+split.substring(3)+split.substring(0,1)+split.substring(1,2);
		else
			return "x"+split.substring(2,3)+split.substring(3,4)+split.substring(0,1)+split.substring(1,2) +split.substring(4);

	}
}
