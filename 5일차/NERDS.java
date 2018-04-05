import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.sound.sampled.Line;

public class NERDS {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			List<Point> nerds = new ArrayList<>();
			List<Point> others = new ArrayList<>();
			for (int n = 0; n < N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				if (Integer.parseInt(st.nextToken())==1) {
					nerds.add( new Point( Integer.parseInt( st.nextToken()), Integer.parseInt(st.nextToken() ) ) );

				} else {
					others.add( new Point( Integer.parseInt( st.nextToken()), Integer.parseInt(st.nextToken() ) ) );
				}
			}
//			if(nerdArea) {
//				System.out.println("THEORY IS INVALID");
//
//			} else {
//				System.out.println("THEORY HOLDS");
//			}
		}

	}

	private static boolean isCrossed() {
		
		return false;
		
	}
	
	private static List<Point> findConvexHull(List<Point> dots){
		List<Point> convexHull = new ArrayList<>();
		
		
		
		return convexHull;
	}
	
	private static double findAngle(Point startingPoing, Point mostLeftPoint, Point compareingPoint) {
		
		
		return 0;
		
	}

}
