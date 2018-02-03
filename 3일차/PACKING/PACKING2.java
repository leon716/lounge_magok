import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PACKING2 {
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 0  ; t < T ; t++ ) {
		
			int n = sc.nextInt();
			int w = sc.nextInt();
			int max = 0 ;
			int[] maxArr = new int[w+1];
			List<String[]> list = new ArrayList<>();
			sc.nextLine();
			for(int i = 0 ; i < n ; i++ ) {
				String[] things = new String[3];

				String temp = sc.nextLine();
				things[0] = temp.split(" ")[0];//이름
				things[1] = temp.split(" ")[1];//부피
				things[2] = temp.split(" ")[2];//절박도
				list.add(things);
			}
			for(int i = 1 ; i < w+1 ; i++ ) {
				
				for(int j = 0 ; j < list.size() ; j++ ) {
					if(i-Integer.parseInt(list.get(j)[1])>=0) {
						if(maxArr[i] < maxArr[i-Integer.parseInt(list.get(j)[1])]+Integer.parseInt(list.get(j)[2])) {
							maxArr[i] = maxArr[i-Integer.parseInt(list.get(j)[1])]+Integer.parseInt(list.get(j)[2]);
							if(max<maxArr[i]) {
								max = maxArr[i];
								list.remove(j);
							}
						}
					}
					
					
				}
				
			}
			System.out.println(max+" ");
			/*for(int i = 0 ; i < temp.size() ; i++ ) {
				System.out.println(temp.get(i)[0]);
			}*/
			
		}
		
		
		sc.close();
		
	}
	


}
