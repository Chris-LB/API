import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

	public static void main(String[] args) {
		try {
			FileWriter myWriter = new FileWriter("names.txt");
			myWriter.write("Abe" + "\n");
			myWriter.write("barb" + "\n");
			myWriter.write("chris" + "\n");
			myWriter.write("debby" + "\n");
			myWriter.write("barb" + "\n");
			myWriter.write("ethan" + "\n");
			myWriter.write("nick" + "\n");
			myWriter.write("debby" + "\n");
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

}
