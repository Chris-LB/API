import java.io.File;
import java.io.IOException;

public class CreateFile {

	public static void main(String[] args) {
		try {
			File myObj = new File("names.txt");
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
				System.out.println("Abe");
				System.out.println("barb");
				System.out.println("chris");
				System.out.println("debby");
				System.out.println("barb");
				System.out.println("ethan");
				System.out.println("nick");
				System.out.println("debby");
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

}
