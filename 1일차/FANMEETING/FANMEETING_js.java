import java.util.Scanner;

public class FANMEETING {

	static String hyps;
	static String fans;
	static int T;
	static int answer;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		sc.nextLine();
		for(int t = 0 ; t < T ; t++ ) {
			
			hyps = sc.nextLine();
			fans = sc.nextLine();
			int len = fans.length() - hyps.length() + 1;
			
			
			for(int i = 0 ; i < len ; i ++ ) {
				answer += hug(i);
			}
			System.out.println(answer);
		}
		sc.close();
		
		
		
	}
	
	public static int hug(int index) {
		
		int result = 1;
		for(int i = 0 ; i < hyps.length() ; i ++ ) {
			result *= calc(hyps.charAt(i), fans.charAt(i+index));
			if(result == 0 ) {
				return result;
			}
		}
		return result;
		
	}
	
	public static int calc(char hyp, char fan) {
		
		int result = 0;
		
		if(hyp=='M' && fan == 'M') {
			result = 0;
		} else {
			result = 1;
		}
		
		return result;
		
	}

}
