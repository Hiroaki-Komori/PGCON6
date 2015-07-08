package oldJava;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;

public class Main {

	public static void main(String[] args) {
		BitSet numbers = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int L = 0;
		int N = 0;
		int answer=0;
		try {
			// Line 1 Target length. (The largest candidate is L-2-1 )
			L=Integer.parseInt(reader.readLine());
			numbers = new BitSet(L);
//			System.out.println("L="+L);
			// Line2
			N = Integer.parseInt(reader.readLine());
//			System.out.println("N="+N);
			// Below Line3
			for (int i = 1; i <= N; i++) {
				String token = reader.readLine();
//				System.out.println("token: "+token);
				numbers.set(Integer.parseInt(token));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//	n1 < n2 < n3
		//	when n1:max
		//		n1max < n2 (= floor(N/3)) < n3min
		//		floor(N/3) < n3min
		for (int n1 = 1; n1 < Math.floor(L / 3); n1++) {
//			System.out.println("n1="+n1);
			if (numbers.get(n1)) {
				for (int n2 = n1 + 1; n2 < Math.floor((L - n1) / 2); n2++) {
//					System.out.println("\tn2="+n2);
					if(numbers.get(n2)){
						if(numbers.get(L-n1-n2)){
//							System.out.println("\t\tn3="+(L-n1-n2));
							answer++;
						}
					}
				}
			}
		}
		System.out.println(answer);
	}
}
