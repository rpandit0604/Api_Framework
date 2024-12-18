package session2_Dyanmic_Advance_payload;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class multiparameterization {

	String id;
	@Test(dataProvider="book_data")
	public void addBook1(String isbn,String aisle)
	{
		RestAssured.baseURI="http://216.10.245.166";
		String add_response= given().header("Content-type","application/json").body(payload.Add(isbn,aisle))
		.when().post("/Library/Addbook.php")
		.then().extract().response().asString();
		
		System.out.println(add_response);
		
		JsonPath js=new JsonPath(add_response);
		id= js.get("ID");
		System.out.println(id);
		
	}
	
	@Test(dependsOnMethods = "addBook1")
	public void deletebook()
	{
		RestAssured.baseURI="http://216.10.245.166";
		System.out.println(id);
		String del_response=given().header("Content-type","application/json").body("{\r\n"
				+ "    \"ID\": \""+id+"\"\r\n"
				+ "}")
				.when().delete("/Library/DeleteBook.php")
				.then().extract().response().asString();
		System.out.println("this : "+id+""+del_response);
	}
	
	@DataProvider(name="book_data")
	public Object[][] getData()
	{
		//array=collection of elements
		//multidimesnional array= collection of array                        string       integer
		//new object[][]   {{"abc","123"},{"acd","234"},{"abg","111"},{"abcj","456"},{"bcd",987}}
		
		
		
		return new Object[][] {{"asop","123"},{"acod","234"},{"abog","111"},{"abcj","456"},{"dbcd","989"}};
	}
}
