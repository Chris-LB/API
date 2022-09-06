import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class test {

	public static void main(String args[]) throws FileNotFoundException {

		File f = new File("names.txt");
		ArrayList<String> arr = new ArrayList<String>();
		Set<String> listOfWords = new HashSet<String>();
		Scanner in = new Scanner(f);
		int i = 0;
		int count = 0;
		String bigWord = " ";
		while (in.hasNext()) {
			String s = in.next();
			arr.add(s);
			count++;
		}
		in.close();
		Scanner scanner = new Scanner(f);
		while (scanner.hasNextLine()) {
			Scanner wordScanner = new Scanner(scanner.nextLine());
			while (wordScanner.hasNext()) {
				String str = wordScanner.next();
				if (str.length() > bigWord.length())
					bigWord = str;
			}
			wordScanner.close();
		}
		scanner.close();
		System.out.println("Total number of words: " + count);
		System.out.println("Longest word: " + bigWord);

		for (String name : arr) {
			if (listOfWords.add(name) == false)
				System.out.println(name + " is a duplicate");
		}

		System.out.println("The number of unique words: " + listOfWords.size());

	}
}
