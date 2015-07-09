package trash;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
	public static void main(String[] args) {
		//BitSet numbers = null;
		//List<Boolean> numbers = null;
		boolean[] numbers = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int L = 0;
		int N = 0;
		int answer=0;
		try {
			// Line 1 Target length. (The largest candidate is L-2-1 )
			L=Integer.parseInt(reader.readLine());
			//numbers = new BitSet(L);
			//numbers = new ArrayList<Boolean>(L);
			numbers = new boolean[L+1];
			// Line2
			N = Integer.parseInt(reader.readLine());
			// Below Line3
			for (int i = 1; i <= N; i++) {
				String token = reader.readLine();
				//numbers.set(Integer.parseInt(token));
				int index = Integer.parseInt(token);
				numbers[index]= true;
				//numbers.set(index,new Boolean(true));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//	n1 < n2 < n3
		//	when n1:max
		//		n1max < n2 (= floor(N/3)) < n3min
		//		floor(N/3) < n3min
		double n1max = Math.floor(L / 3);
		for (int n1 = 1; n1 < n1max; n1++) {
//			System.out.println("count"+n1);
//			if (numbers.get(n1)) {
			if (numbers[n1]){
				int remain = L-n1;
				double n2max = Math.ceil((double)remain / 2);
				for (int n2 = n1 + 1; n2 < n2max; n2++) {
					//if(numbers.get(n2)){
					if(numbers[n2]){
						if(numbers[remain-n2]){
					//if(numbers.get(L-n1-n2) ){
							answer++;
						}
					}
				}
			}
		}
		System.out.println(answer);
	}
}
