import java.util.Scanner;

public class LUNCHBOX {

	static int max;
	static int microMax;
	static int eatingMax;
	static int[][] time; 
	static int[] temp;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for(int t = 0 ; t < testCase ; t++ ) {
			int n = sc.nextInt();
			
			time = new int[n][2];
			temp = new int[n];
			
			for(int i = 0 ; i < n ; i++ ) {
				time[i][0] = sc.nextInt();
			}
			for(int i = 0 ; i < n ; i++ ) {
				time[i][1] = sc.nextInt();
			}
			mergesort(0, n-1);
			for(int i = 0 ; i < n ; i++ ) {
				//TO-DO 부분 최대합 구하기
				max = Math.max(microMax, eatingMax);
			}
			
		}
		
	}
	
	private static void mergesort(int low, int high) {

        if (low < high) {

            int middle = low + (high - low) / 2;

            mergesort(low, middle);

            mergesort(middle + 1, high);

            merge(low, middle, high);
        }
    }

    private static void merge(int low, int middle, int high) {


        for (int i = low; i <= high; i++) {
            temp[i] = time[i][1];
        }

        int i = low;
        int j = middle + 1;
        int k = low;


        while (i <= middle && j <= high) {
            if (temp[i] > temp[j]) {
                time[k][1] = temp[i];
                i++;
            } else {
                time[k][1] = temp[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            time[k][1] = temp[i];
            k++;
            i++;
        }



    }
}
