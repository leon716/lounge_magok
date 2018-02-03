import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PACKING {
	
	static List<String[]> list;
	static List<String[]> temp;
	static int max;
	static int wLimit;
	static int minW = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 0  ; t < T ; t++ ) {
		
			int n = sc.nextInt();
			int w = sc.nextInt();
			wLimit = w;
			list = new ArrayList<>();
			temp = new ArrayList<>();
			sc.nextLine();
			for(int i = 0 ; i < n ; i++ ) {
				String[] things = new String[3];

				String temp = sc.nextLine();
				things[0] = temp.split(" ")[0];
				things[1] = temp.split(" ")[1];
				things[2] = temp.split(" ")[2];
				list.add(things);
				minW = Math.min(Integer.parseInt(things[1]), minW);
			}
			findThing();
			System.out.println(max+" "+temp.size());
			for(int i = 0 ; i < temp.size() ; i++ ) {
				System.out.println(temp.get(i)[0]);
			}
			
		}
		
		
		sc.close();
		
	}
	
	public static void findThing() {
		int localMax = 0;
		String[] effThing = null;
		double maxEff = 0;
		for(String[] e : list) {
			if(wLimit>Integer.parseInt(e[1])) {
				double eff = Integer.parseInt(e[2])/Integer.parseInt(e[1]);
				if(eff>maxEff) {
					maxEff = eff;
					effThing = e;
				}
			}
			
		}
		if(null == effThing) {
			return;
		}
		localMax = Integer.parseInt(effThing[2]);
		temp.add(effThing);
		max += localMax;
		list.remove(effThing);
		wLimit -= Integer.parseInt(effThing[1]);
		if(wLimit>=minW) {
			findThing();
		}
	}

}
