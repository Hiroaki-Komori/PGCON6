package inputGenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Generator {
	public static void main(String[] args) {
		File source = new File("./bin/input.txt");
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(source));
			source.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int L = 2000000;
		int N = 200000;
		List<Integer> seeds = new ArrayList<>();
		for (int i = 1; i <= L; i++) {
			seeds.add(i);
		}
		Collections.shuffle(seeds);
		seeds = seeds.subList(0, N);
		Collections.sort(seeds);
		try{
			writer.write(String.valueOf(L));
			writer.newLine();
			writer.write(String.valueOf(N));
			writer.newLine();
		for (int num: seeds) {
//			System.out.println(num);
			writer.write(String.valueOf(num));
			writer.newLine();
		}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
