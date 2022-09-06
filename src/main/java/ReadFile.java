import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class ReadFile {

	public static void main(String[] args) {
		try {
			File myObj = new File("names.txt");
			Scanner myReader = new Scanner(myObj);
			int count = 0;
			int i = 0;
			ArrayList arr = new ArrayList();
			HashMap<String, Integer> listOfWords = new HashMap<String, Integer>();
			String bigWord = " ";
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
				arr.add(data);
				count++;

			}
			myReader.close();
			Scanner scanner = new Scanner(myObj);
			while (scanner.hasNextLine()) {
				Scanner wordScanner = new Scanner(scanner.nextLine());
				while (wordScanner.hasNext()) {
					String str = wordScanner.next();
					if (str.length() > bigWord.length())
						bigWord = str;
				}
			}
			scanner.close();
			Iterator itr = (Iterator) arr.iterator();
			while (itr.hasNext()) {
				i++;

				listOfWords.put((String) itr.next(), i);
			}

			Set<Object> uniqueValues = new HashSet<Object>(listOfWords.values());

			System.out.println("The number of unique words: " + uniqueValues.size());
			System.out.println(count);
			System.out.println(bigWord);
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

}
