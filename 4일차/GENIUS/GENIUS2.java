import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GENIUS2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0 ; t < T ; t++ ) {
			int n = sc.nextInt(); //곡수
			int k = sc.nextInt(); //분
			int m = sc.nextInt();//태윤이가 좋아하는 곡 수 
			
			int[] length = new int[n];//곡 길이 저장
			double[][] prob = new double[n][n];//[행][열]
			List<Integer> like= new ArrayList<>();
			double[][]	probMemo = new double[k+1][n];
			
			
			for(int i = 0 ; i < n ; i ++ ) {
				length[i] = sc.nextInt();
			}
			for(int i = 0 ; i < n ; i ++ ) {
				for(int j = 0 ; j < n ; j++ ) {
					prob[i][j] = sc.nextDouble();
				}
			}
			for(int i = 0 ; i < n ; i++ ) {
				like.add(sc.nextInt());
			}
			probMemo[0][0] = 1;
			for(int time = 0 ; time <= k ; time ++ ) {
				for(int i = 0 ; i < n ; i++ ) {
					probMemo[time][i] = 0;
					for(int j = 0 ; j < n ; j++ ) {
						if(time-length[j]>=0) {
							probMemo[time][i] += probMemo[time-length[j]][j]*prob[i][j];
							System.out.println(probMemo[time][i]);

						}
					}
				}
			}
			for(int i = 0 ; i < m ; i++ ) {
				int song = like.remove(0);
				double sum = 0 ;
				for(int j = k-length[song]; j <= k; j++ ) {
					sum += probMemo[j][song];
				}
				System.out.print(sum+" ");
			}
		}
		
	}

}
