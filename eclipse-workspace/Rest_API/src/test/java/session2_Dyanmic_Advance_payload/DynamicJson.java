package session2_Dyanmic_Advance_payload;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class DynamicJson {
	
	String id;
	@Test(priority = 1)
	public void AddBook()
	{
		RestAssured.baseURI="http://216.10.245.166";
		String response= given().header("Content-type","application/json").body(payload.Add("A123D","2345"))
		.when().post("/Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js=new JsonPath(response);
		id= js.getString("ID");
		System.out.println("Generated ID is : "+ id);
		
	}
	
	@Test(dependsOnMethods = "AddBook", priority = 2, enabled = false)
	public void deleteBook()
	{
		RestAssured.baseURI="http://216.10.245.166";
		String Res_delete =given().log().all().body("{\r\n"
				+ "  \"ID\": \""+id+"\"\r\n"
				+ "}")
		.when().delete("/Library/DeleteBook.php")
		.then().extract().response().asString();
		System.out.println(Res_delete);
	}
	
	@Test(dependsOnMethods = {"AddBook"})
	public void getBook()
	{
		
		System.out.println("here is the id: "+id);
		RestAssured.baseURI="http://216.10.245.166";
		String res_get= given().log().all().queryParam("ID", id)
		.when().get("/Library/GetBook.php")
		.then().extract().response().asString();
		System.out.println("Response in Get method --> "+res_get);
		
		
	}
}
