package template;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class stream {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new FileReader(""));
		String str = bf.readLine();
		PrintWriter fw = new PrintWriter(new FileWriter(new File(""), true));
		fw.println(str);
	}

}
