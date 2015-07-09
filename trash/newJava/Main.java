package newJava;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		//BitSet numbers = null;
		boolean[] numbers = null;
		int length = 0;
		try {
			Reader reader = new Reader();
			numbers = reader.getNumbers();
			length = reader.getLength();
			reader.close();
			Finder finder = new Finder(numbers, length);
			System.out.println(finder.getCombinations());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class Reader implements Closeable {
	//BitSet numbers = null;
	boolean[] numbers;
	private int length = 0;

	Reader() throws IOException {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in))) {
			// Line 1 Target length. (The largest candidate is L-2-1 )
			length = Integer.parseInt(reader.readLine());
			//numbers = new BitSet(length);
			numbers = new boolean[length+1];
			// System.out.println("L="+L);
			// Line2
			int N = Integer.parseInt(reader.readLine());
			// System.out.println("N="+N);
			// Below Line3
			for (int i = 1; i <= N; i++) {
				String token = reader.readLine();
				// System.out.println("token: "+token);
				//numbers.set(Integer.parseInt(token));
				numbers[Integer.parseInt(token)]=true;
			}
		}
	}

	boolean[] getNumbers() {
		return numbers;
	}

	int getLength() {
		return length;
	}

	@Override
	public void close() throws IOException {
	}
}

class Finder {
	int combinations = 0;

	// n1 < n2 < n3
	// when n1:max
	// n1max < n2 (= floor(N/3)) < n3min
	// floor(N/3) < n3min
	//Finder(BitSet numbers, int length) {
	Finder(boolean[] numbers, int length) {
		double n1max = Math.floor(length/3);
		for (int n1 = 1; n1 < n1max; n1++) {
			//if (numbers.get(n1)) {
			if(numbers[n1]){
				int remain = length - n1;
				double n2max = Math.ceil((double)(remain / 2));
				for (int n2 = n1 + 1; n2 < n2max; n2++) {
					//if(numbers.get(n2)){
					if(numbers[n2]){
					//if(numbers.get(remain - n2) ){
					if(numbers[remain - n2]){
						combinations++;
						}
					}
				}
			}
		}
	}

	int getCombinations() {
		return combinations;
	}
}