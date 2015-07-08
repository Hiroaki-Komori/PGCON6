package newJava;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;

public class Main {
	public static void main(String[] args) {
		BitSet numbers = null;
		int length = 0;
		try {
			Reader reader = new Reader();
			numbers = reader.getNumbers();
			length = reader.getLength();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Finder finder = new Finder(numbers, length);
		System.out.println(finder.getCombinations());
	}
}

class Reader implements Closeable {
	private BitSet numbers = null;
	private int length = 0;

	Reader() throws IOException {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in))) {
			// Line 1 Target length. (The largest candidate is L-2-1 )
			length = Integer.parseInt(reader.readLine());
			numbers = new BitSet(length);
			// System.out.println("L="+L);
			// Line2
			int N = Integer.parseInt(reader.readLine());
			// System.out.println("N="+N);
			// Below Line3
			for (int i = 1; i <= N; i++) {
				String token = reader.readLine();
				// System.out.println("token: "+token);
				numbers.set(Integer.parseInt(token));
			}
		}
	}

	BitSet getNumbers() {
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
	Finder(BitSet numbers, int length) {
		for (int n1 = 1; n1 < Math.floor(length / 3); n1++) {
			// System.out.println("n1="+n1);
			if (numbers.get(n1)) {
				for (int n2 = n1 + 1; n2 < Math.floor((length - n1) / 2); n2++) {
					// System.out.println("\tn2="+n2);
					if (numbers.get(n2) && numbers.get(length - n1 - n2)) {
						// System.out.println("\t\tn3="+(L-n1-n2));
						combinations++;
					}
				}
			}
		}
	}

	int getCombinations() {
		return combinations;
	}
}