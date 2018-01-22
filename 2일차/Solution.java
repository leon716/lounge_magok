package Napo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long a, b, c, answer = 0;
		int k;
		for (int i = 0; i < N; i++) {
			a = sc.nextLong();
			b = sc.nextLong();
			k = sc.nextInt();
			c = (int) (Math.log10(b) + 1);
			ArrayList<Long> ans = new ArrayList<>();
			makeTree(c, ans, a, b);
			System.out.println(ans.get(k));
		}
	}

	// private static ArrayList<Long> makeArray(Tree<Long> tr, long a, long b) {
	// Stack<Node<Long>> st = new Stack<>();
	// ArrayList<Long> temp = new ArrayList<>();
	// Node<Long> temp2;
	// st.push(tr.root);
	// while (!st.isEmpty()) {
	// temp2 = st.pop();
	// if ( temp2.data >= a && temp2.data <= b) {
	// temp.add(temp2.data);
	// }
	// if (temp2.children != null) {
	// for (int i = 9; i >= 0; i--) {
	// st.add(temp2.children.get(i));
	// }
	// }
	// }
	// return temp;
	// }

	static void makeTree(long c, ArrayList<Long> ans, long a, long b) {
		Tree<Long> tree = new Tree((long) 0);
		Node<Long> root = tree.root;
		makechildren(root, c, ans, a, b);
	}

	static void makechildren(Node<Long> node, long c, ArrayList<Long> ans, long a, long b) {
		if (node.children == null) {
			ArrayList<Node<Long>> ar = new ArrayList<>();
			for (long i = 0; i < 10; i++) {
				if (i == 0 && node.data == 0) {
					continue;
				}
				Node<Long> temp = new Node();
				temp.data = node.data * 10 + i;
				temp.parent = node;
				if (temp.data >= a && temp.data <= b) {
					ans.add(temp.data);
				}
				if (c > 0) {
					makechildren(temp, c - 1, ans, a, b);
				}
				ar.add(temp);
			}
			node.children = ar;
		}
	}
}

class Tree<T> {
	public Node<Long> root;

	public Tree(Long rootData) {
		root = new Node<Long>();
		root.data = rootData;
	}

	@Override
	public String toString() {
		return "Tree [root=" + root + "]";
	}
}

class Node<Long> {
	public Long data;
	public Node<Long> parent;
	public List<Node<Long>> children;

}