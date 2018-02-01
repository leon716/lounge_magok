import java.util.Scanner;

public class SUSHI {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 0 ; t < T ; t++ ) {
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			int temp = (( m - ( m % 100 )) / 100)+1;
			int max = 0;
			int[][] price = new int[n][2];
			int[] pref = new int[ temp ];
			
			for(int i = 0 ; i < n ; i++) {
				
				price[i][0] = sc.nextInt()/100;
				price[i][1] = sc.nextInt();
				
			}
			for(int i = 0 ; i < temp ; i++ ) {
				
				for(int j = 0 ; j < n ; j++ ) {
					if(i-price[j][0]>=0) {
						if(pref[i] < pref[i-price[j][0]]+price[j][1]) {
							pref[i] = pref[i-price[j][0]]+price[j][1];
							//System.out.println(pref[i]);
						}
					}
					
					
				}
				
			}
			for(int i = 0 ; i < temp ; i++ ) {
				max = Math.max(pref[i], max);
			}
			System.out.println(max);
		}
		sc.close();
		
	}

}
