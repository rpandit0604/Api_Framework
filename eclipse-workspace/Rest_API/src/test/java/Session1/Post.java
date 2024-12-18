package Session1;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class Post {

	public static void main(String args[])
	{
		//validate if APi is working or not
		
		//given- all input details(parameter,header,auth,body)
		//when - submit the API  //add resource,http method post,get...
		//then - validate the response  
		
		RestAssured.baseURI="https://rahulshettyacademy.com";  //providing the url
		
		given().queryParam("key","qaclick123").header("content-type","application/json")
		.body(payload_addplace.addApi())
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server","Apache/2.4.52 (Ubuntu)");
		
	}
}