import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Area;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NERDS {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			Polygon nerd = new Polygon();
			Polygon other = new Polygon();
			List<Point> nerds = new ArrayList<>();
			for (int n = 0; n < N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				if (Integer.parseInt(st.nextToken())==1) {
					nerd.addPoint(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

				} else {
					other.addPoint(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				}
			}
			nerd.
			Area nerdArea = new Area(nerd);
			Area otherArea = new Area(other);
			if(nerdArea.) {
				System.out.println("THEORY IS INVALID");

			} else {
				System.out.println("THEORY HOLDS");
			}
		}

	}
	private static boolean isCrossed()

}
