package session2_Dyanmic_Advance_payload;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class takingValueFromFile {
	
	
	@Test
	public static void json_file() throws IOException
	{
		
		RestAssured.baseURI="http://216.10.245.166";
		RestAssured.baseURI="http://216.10.245.166";
		String add_response= given().header("Content-type","application/json").body(data_json("C:\\Users\\rospandi\\Downloads\\API\\Api_data.JSON"))
		.when().post("/Library/Addbook.php")
		.then().extract().response().asString();
		System.out.println(add_response);
	}
	
	public static String data_json(String p) throws IOException
	{
		
			String s= new String(Files.readAllBytes(Paths.get(p)));
			return s;
	}

}
