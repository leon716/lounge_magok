import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1005 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int[] time = new int[N];
			for (int i = 0; i < N; i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}
			List<Order> order = new ArrayList<>();
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				Order temp = new Order();
				temp.setBefore(Integer.parseInt(st.nextToken()));
				temp.getNext().add(Integer.parseInt(st.nextToken()));
				for (int j = 0; j < order.size(); j++) {
					
				}
				order.add(temp);
			}

		}

	}

}

class Order {
	int before;
	List<Integer> next;
	int order;

	public Order() {
		super();
		this.next = new ArrayList<>();
	}

	public int getBefore() {
		return before;
	}

	public void setBefore(int before) {
		this.before = before;
	}

	public List<Integer> getNext() {
		return next;
	}

	public void setNext(List<Integer> next) {
		this.next = next;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

}