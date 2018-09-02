import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1149 {

	public static void main(String[] args) throws NumberFormatException, IOException {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[N][3];
		int min;
		
		for(int n = 0 ; n < N ; n++ ) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int redCost = Integer.parseInt(st.nextToken());
			int greenCost = Integer.parseInt(st.nextToken());
			int blueCost = Integer.parseInt(st.nextToken());
		}
		
		
		
		
		
	}

}
