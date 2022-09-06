//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		/*
		 * Maven dependency for JSON-simple: <dependency>
		 * <groupId>com.googlecode.json-simple</groupId>
		 * <artifactId>json-simple</artifactId> <version>1.1.1</version> </dependency>
		 */

		try {
			// Public API:
			// https://www.metaweather.com/api/location/search/?query=<CITY>
			// https://www.metaweather.com/api/location/44418/

			String urlString = "https://wpapi.telugupuzzles.com/api/getLength.php?string=metrostate&language=English";
			URL url = new URL(urlString);

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			String userAgentValue = "Mozilla/5.0 (X11; CrOS x86_64 8172.45.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.64 Safari/537.36";
			connection.setRequestProperty("User-Agent", userAgentValue);
//			connection.setRequestProperty("Content-Type", "application/json");
			connection.connect();
			// Check if connect is made
			int responseCode = connection.getResponseCode();

			// 200 OK
			if (responseCode != 200) {
				throw new RuntimeException("HttpResponseCode: " + responseCode);
			} else {

				StringBuilder informationString = new StringBuilder();
				Scanner scanner = new Scanner(url.openStream());

				while (scanner.hasNext()) {
					informationString.append(scanner.nextLine());
				}
				// Close the scanner
				scanner.close();

				StringBuilder responseString = new StringBuilder();
				ArrayList<String> responseArrayStrings = new ArrayList<String>(
						Arrays.asList(informationString.toString().split("")));

				boolean readingAfterCurlyBrace = false;
				for (String string : responseArrayStrings) {

					if (readingAfterCurlyBrace) {
						responseString.append(string);

					} else if (string.equalsIgnoreCase("{")) {
						readingAfterCurlyBrace = true;
						responseString.append(string);
					}
				}
				// remove BOM
//				byte[] responseStringBytes = responseString.getBytes();
//				responseString = new String(responseStringBytes, "UTF-8");
//				ObjectMapper mapper = new ObjectMapper();
//				Map<String, Object> map = mapper.readValue(json, Map.class);

				System.out.println(responseString);
//
//
//                //JSON simple library Setup with Maven is used to convert strings to JSON
//                JSONParser parse = new JSONParser();
//                JSONArray dataObject = (JSONArray) parse.parse(String.valueOf(informationString));
//
//                //Get the first JSON object in the JSON array
//                System.out.println(dataObject.get(0));
//
//                JSONObject countryData = (JSONObject) dataObject.get(0);
//
//                System.out.println(countryData.get("woeid"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
